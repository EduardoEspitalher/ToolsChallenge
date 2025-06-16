package com.tools.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tools.challenge.dto.WrapperDTO;
import com.tools.challenge.dto.description.DescriptionDTO;
import com.tools.challenge.dto.paymentMethod.PaymentMethodDTO;
import com.tools.challenge.dto.transation.TransactionDTO;

import com.tools.challenge.enumeration.PaymentType;
import com.tools.challenge.model.Transaction;
import com.tools.challenge.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveSalvarTransacao() throws Exception {
        TransactionDTO dto = new TransactionDTO();
        dto.setCardNumber("4444********1234");
        dto.setDescription(new DescriptionDTO());
        dto.setPaymentMethod(new PaymentMethodDTO());
        dto.getPaymentMethod().setType(PaymentType.AVISTA);
        dto.getPaymentMethod().setInstallments(1L);

        WrapperDTO wrapper = new WrapperDTO(dto);

        mockMvc.perform(post("/payment/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wrapper)))
                .andExpect(status().isCreated());

        verify(service, times(1)).save(any(TransactionDTO.class));
    }

    @Test
    void deveListarTransacoes() throws Exception {
        when(service.list()).thenReturn(Collections.singletonList(new TransactionDTO()));

        mockMvc.perform(get("/payment/transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transacoes").isArray());
    }

    @Test
    void deveBuscarPorId() throws Exception {
        when(service.findById(1L)).thenReturn(new TransactionDTO());

        mockMvc.perform(get("/payment/transactions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transacao").exists());
    }

    @Test
    void deveEstornarTransacao() throws Exception {
        when(service.refound(1L)).thenReturn(new Transaction());

        mockMvc.perform(delete("/payment/transactions/1"))
                .andExpect(status().isOk());

        verify(service).refound(1L);
    }

}