package com.company.dao.impl;

import com.company.dao.inter.TransactionDaoInter;
import com.company.entity.Transaction;
import main.Abstract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl extends Abstract implements TransactionDaoInter {

    private static Transaction getTransaction(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String fromAcc = rs.getString("from_account");
        String toAcc = rs.getString("to_account");
        double amount = rs.getDouble("amount");

        Transaction transaction = new Transaction(id,fromAcc,toAcc,amount);
        return transaction;
    }


    @Override
    public boolean insert(Transaction tr){
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into transactions(id,from_account,to_account,amount) values(?,?,?,?) ");
            stmt.setInt(1,tr.getId());
            stmt.setString(2,tr.getFromAccount());
            stmt.setString(3,tr.getToAccount());
            stmt.setDouble(4,tr.getAmount());

           return stmt.execute();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Transaction> getAllTransactions(){
       List<Transaction> tr = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from transactions");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Transaction transaction= getTransaction(rs);
                tr.add(transaction);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  tr;
    }
    @Override
    public Transaction getTransaction(){
        Transaction tr = new Transaction();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from transactions");
            stmt.execute();
           ResultSet rs = stmt.getResultSet();
           while(rs.next()){
             tr= getTransaction(rs);

           }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  tr;
    }
    @Override
    public List<Transaction> getFromAccount( String fromAccount){
        List<Transaction> tr = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from transactions where from_account=?");
            stmt.setString(1,fromAccount);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Transaction transaction = getTransaction(rs);
                tr.add(transaction);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  tr;
    }
    @Override
    public List<Transaction> getToAccount(String toAccount){
        List<Transaction> tr = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from transactions where to_account=?");
            stmt.setString(1,toAccount);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Transaction transaction = getTransaction(rs);
                tr.add(transaction);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  tr;
    }
    @Override
    public List<String> getAccountNumbers( String emaill){
        List<String> list = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select acc_number from account where email=?");
            stmt.setString(1,emaill);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                String accountNumber = rs.getString("acc_number");
                list.add(accountNumber);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  list;
    }
    @Override
    public List<Transaction> getTransactions(List<String> accountNumbers){
        List<Transaction> list = new ArrayList<>();
        for(String s:accountNumbers) {
            try (Connection c = connect()) {
                PreparedStatement stmt = c.prepareStatement("select * from transactions where from_account=?");
                stmt.setString(1,s);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()){
                    Transaction transaction = getTransaction(rs);

                    list.add(transaction);

                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
