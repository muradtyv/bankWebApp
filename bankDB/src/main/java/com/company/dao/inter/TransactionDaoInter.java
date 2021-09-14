package com.company.dao.inter;

import com.company.entity.Transaction;

import java.util.List;

public interface TransactionDaoInter {
    public boolean insert(Transaction tr);

    public List<Transaction> getAllTransactions();

    public Transaction getTransaction();

    public List<Transaction> getFromAccount( String fromAccount);

    public List<Transaction> getToAccount(String toAccount);

    public List<Transaction> getTransactions(List<String> accountNumbers);

    public List<String> getAccountNumbers( String emaill);
}
