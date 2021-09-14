package com.company.entity;

import main.Abstract;

public class BankAccount extends Abstract {
    private int id;
    private String customerNAme;
    private String exchange="AZN";
    private String accountNumber;
    private double balance=300;
    private String status ="Deactive";
    private String email;

    public BankAccount(int id, String customerNAme, String exchange, String accountNumber, double balance, String status,String email) {
        this.id = id;
        this.customerNAme = customerNAme;
        this.exchange = exchange;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.status = status;
        this.email=email;
    }

    public BankAccount(int id, String customerNAme, String accountNumber) {
        this.id = id;
        this.customerNAme = customerNAme;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerNAme() {
        return customerNAme;
    }

    public void setCustomerNAme(String customerNAme) {
        this.customerNAme = customerNAme;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customerNAme='" + customerNAme + '\'' +
                ", exchange='" + exchange + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", email='" + email + '\'' +
                '}';
    }
}
