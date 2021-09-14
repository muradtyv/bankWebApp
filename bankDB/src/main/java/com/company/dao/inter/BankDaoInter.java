package com.company.dao.inter;

import com.company.entity.BankAccount;

import java.util.List;

public interface BankDaoInter {
    public void updateStatus(int id);

    public boolean insertAccount(BankAccount b);

    public BankAccount getBankAccount(String accountNumber);

    public List<BankAccount> getAccounts();

    public List<BankAccount> getAccounts(String newEmail);

    public boolean bankAccountIsExist(String accountNumber );

    public boolean delete(int id );

    public String active(String accNumber);

    public void transfer(String fromAccount, String toAccount,double amount) throws Exception;


}
