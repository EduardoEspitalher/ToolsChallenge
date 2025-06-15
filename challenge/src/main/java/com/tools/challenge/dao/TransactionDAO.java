package com.tools.challenge.dao;

import com.tools.challenge.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TransactionDAO {

    private final Map<Long, Transaction> transactions = new HashMap<>();

    public Transaction getById(Long id) {
        return transactions.get(id);
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
        long nsu = ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L);
        return String.valueOf(nsu);
    }

    public String generateAuthorizationCode() {
        long authorization = ThreadLocalRandom.current().nextLong(0, 1_000_000_000L);
        return String.format("%09d", authorization);
    }
}
