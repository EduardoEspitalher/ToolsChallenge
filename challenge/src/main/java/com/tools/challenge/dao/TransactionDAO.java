package com.tools.challenge.dao;

import com.tools.challenge.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionDAO {

    private final Map<Long, Transaction> transactions = new HashMap<>();

    public Transaction getById(Long id) {
        return transactions.get(id);
    }

    public Boolean deleteById(Long id) {
        return transactions.remove(id) != null;
    }

    public Transaction save(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
        return transaction;
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(transactions.values());
    }

    public Long nextId() {
        return transactions.size() + 1L;
    }

    public String generateNsu() {
        long nsu = (long) (Math.random() * 1_000_000_0000L);
        String formattedNsu = String.format("%010d", nsu);
        return formattedNsu;
    }

    public String generateAuthorizationCode() {
        long authorization = (long) (Math.random() * 1_000_000_00L);
        String formattedAuthorization = String.format("%09d", authorization);
        return formattedAuthorization;
    }
}
