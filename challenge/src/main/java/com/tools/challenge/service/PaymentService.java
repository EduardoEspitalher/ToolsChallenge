package com.tools.challenge.service;

import com.tools.challenge.dao.TransactionDAO;
import com.tools.challenge.dto.transation.TransactionDTO;
import com.tools.challenge.enumeration.StatusType;
import com.tools.challenge.mapper.TransactionMapper;
import com.tools.challenge.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final TransactionMapper mapper;

    private final TransactionDAO transactionDAO;


    public Transaction save(TransactionDTO dto) {
        var payment = mapper.fromDTO(dto);
        payment.setId(transactionDAO.nextId());
        payment.getDescription().setStatus(StatusType.AUTORIZADO);
        payment.getDescription().setNsu(transactionDAO.generateNsu());
        payment.getDescription().setAuthorizationCode(transactionDAO.generateAuthorizationCode());
        return transactionDAO.save(payment);
    }

    public List<TransactionDTO> list() {
        List<Transaction> entities = transactionDAO.getAll();
        return entities.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Transaction refound(Long id, Transaction transaction) {
        var payment = transactionDAO.getById(id);
        payment.getDescription().setStatus(StatusType.valueOf("CANCELADO"));
        return transactionDAO.save(payment);
    }


}
