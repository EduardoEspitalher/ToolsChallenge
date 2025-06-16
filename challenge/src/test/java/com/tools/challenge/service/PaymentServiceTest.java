package com.tools.challenge.service;

import com.tools.challenge.dao.TransactionDAO;
import com.tools.challenge.dto.description.DescriptionDTO;
import com.tools.challenge.dto.paymentMethod.PaymentMethodDTO;
import com.tools.challenge.dto.transation.TransactionDTO;
import com.tools.challenge.enumeration.StatusType;
import com.tools.challenge.exception.InvalidTransactionStateException;
import com.tools.challenge.mapper.TransactionMapper;
import com.tools.challenge.model.Description;
import com.tools.challenge.model.PaymentMethod;
import com.tools.challenge.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    private TransactionMapper mapper;
    private TransactionDAO dao;
    private PaymentService service;

    @BeforeEach
    void setUp() {
        mapper = mock(TransactionMapper.class);
        dao = mock(TransactionDAO.class);
        service = new PaymentService(mapper, dao);
    }

    @Test
    void deveSalvarTransacaoComStatusAutorizadoENsuCodigo() {
        TransactionDTO dto = new TransactionDTO();
        dto.setCardNumber("444********1234");
        dto.setDescription(new DescriptionDTO());
        dto.setPaymentMethod(new PaymentMethodDTO());

        Transaction transaction = new Transaction();
        Description description = new Description();
        transaction.setDescription(description);
        transaction.setPaymentMethod(new PaymentMethod());

        when(mapper.fromDTO(dto)).thenReturn(transaction);
        when(dao.nextId()).thenReturn(1L);
        when(dao.generateNsu()).thenReturn("1234567890");
        when(dao.generateAuthorizationCode()).thenReturn("123456789");
        when(dao.save(transaction)).thenReturn(transaction);

        Transaction result = service.save(dto);

        assertNotNull(result);
        assertEquals(StatusType.AUTORIZADO, result.getDescription().getStatus());
        assertEquals("1234567890", result.getDescription().getNsu());
        assertEquals("123456789", result.getDescription().getAuthorizationCode());
    }

    @Test
    void deveCancelarTransacaoAutorizada() {
        Transaction transaction = new Transaction();
        Description description = new Description();
        description.setStatus(StatusType.AUTORIZADO);
        transaction.setDescription(description);
        transaction.setId(1L);

        when(dao.getById(1L)).thenReturn(transaction);
        when(dao.save(transaction)).thenReturn(transaction);

        Transaction result = service.refound(1L);

        assertEquals(StatusType.CANCELADO, result.getDescription().getStatus());
    }

    @Test
    void deveLancarExcecaoAoCancelarTransacaoJaCancelada() {
        Transaction transaction = new Transaction();
        Description description = new Description();
        description.setStatus(StatusType.CANCELADO);
        description.setNsu("9999999999");
        transaction.setDescription(description);
        transaction.setId(2L);

        when(dao.getById(2L)).thenReturn(transaction);

        InvalidTransactionStateException ex = assertThrows(
                InvalidTransactionStateException.class,
                () -> service.refound(2L)
        );

        assertTrue(ex.getMessage().contains("já está cancelada"));
    }

    @Test
    void deveListarTodasTransacoes() {
        Transaction transaction = new Transaction();
        when(dao.getAll()).thenReturn(List.of(transaction));
        when(mapper.toDTO(transaction)).thenReturn(new TransactionDTO());

        List<TransactionDTO> list = service.list();

        assertEquals(1, list.size());
    }

    @Test
    void deveBuscarTransacaoPorId() {
        Transaction transaction = new Transaction();
        when(dao.getById(1L)).thenReturn(transaction);
        when(mapper.toDTO(transaction)).thenReturn(new TransactionDTO());

        TransactionDTO dto = service.findById(1L);

        assertNotNull(dto);
    }
}
