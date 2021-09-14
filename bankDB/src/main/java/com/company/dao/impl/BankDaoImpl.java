package com.company.dao.impl;

import com.company.dao.inter.BankDaoInter;
import com.company.entity.BankAccount;
import com.company.entity.User;
import main.Abstract;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl extends Abstract implements BankDaoInter {

    private static BankAccount getBankAccount(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String customerName1 = rs.getString("customer_name");
        String exchange1 = rs.getString("exchange");
        String accountNumber1 = rs.getString("acc_number");
        double balance1 = rs.getDouble("balance");
        String status1 = rs.getString("status");
        String email1 = rs.getString("email");


         BankAccount bAccout = new BankAccount(id, customerName1, exchange1, accountNumber1, balance1, status1,email1);
        return bAccout;
    }
    @Override
    public void updateStatus(int id){
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select status from account where id="+id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()){
                String status = rs.getString("status");
                if(status.equals("Deactive")){
                    stmt.executeUpdate("update account set status='Active' where id="+id);
                }else if(status.equals("Active")) {
                    stmt.executeUpdate("update account set status ='Deactive'where id="+id);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public boolean insertAccount(BankAccount b) {
        try(Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("insert into account(customer_name,exchange,acc_number,balance,status,email) values (?,?,?,?,?,?)");
            stmt.setString(1,b.getCustomerNAme());
            stmt.setString(2,b.getExchange());
            stmt.setString(3,b.getAccountNumber());
            stmt.setDouble(4,b.getBalance());
            stmt.setString(5,b.getStatus());
            stmt.setString(6,b.getEmail());
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public BankAccount getBankAccount(String accountNumber){
        BankAccount bAccout = null;
        if(bankAccountIsExist(accountNumber)) {
            try (Connection c = connect()) {
                PreparedStatement stmt = c.prepareStatement("select * from account where acc_number=?");
                stmt.setString(1, accountNumber);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    bAccout= getBankAccount(rs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bAccout;
        }
        System.out.println("There is not that Account");
        return null;
    }
    @Override
    public List<BankAccount> getAccounts(){
        List<BankAccount> list = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from account");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                BankAccount bankAccount= getBankAccount(rs);
                list.add(bankAccount);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  list;
    }

    @Override
    public List<BankAccount> getAccounts(String newEmail){
        List<BankAccount> list = new ArrayList<>();

        try (Connection c = connect()) {
            String sql ="select * from account where ";
            if(newEmail!=null && !newEmail.trim().isEmpty()){
                sql+="account.email=?";
            }
            PreparedStatement stmt = c.prepareStatement(sql);
            if(newEmail!=null && !newEmail.trim().isEmpty()){
                stmt.setString(1,newEmail);
            }
            stmt.execute();
            ResultSet rs =stmt.getResultSet();
            while(rs.next()){
                BankAccount bankAccount= getBankAccount(rs);
                list.add(bankAccount);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  list;
    }
    @Override
    public boolean bankAccountIsExist(String accountNumber ){
        boolean result=false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select acc_number from account where acc_number=?");
            stmt.setString(1,accountNumber);
            stmt.execute();
            ResultSet rs =stmt.getResultSet();
            if(rs.next()){
                result = true;

            }else{
                result =false;

            }
        }catch (Exception ex ){
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public boolean delete(int id ){
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from account where id="+id);
            return  stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public String active(String accNumber){
        String status=null;
        try(Connection c = connect()){
            PreparedStatement stmt = c.prepareStatement("select status from account where acc_number=?");
            stmt.setString(1,accNumber);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()){
                status = rs.getString("status");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  status;
    }
    @Override
    public void transfer(String fromAccount, String toAccount,double amount) throws Exception{
        String a = active(fromAccount);
        String b = active(toAccount);
        if(!(a.equals("Deactive")) && !(b.equals("Deactive")) && (bankAccountIsExist(fromAccount) && (bankAccountIsExist(toAccount)))) {
            try (Connection c = connect()) {
                PreparedStatement stmt= c.prepareStatement("select balance from account where acc_number=?");
                stmt.setString(1,fromAccount);
                stmt.execute();
                ResultSet nrs = stmt.getResultSet();
                if(nrs.next()){
                    double nbalance = nrs.getDouble("balance");
                    if(amount<=nbalance){
                        double newBal = nbalance-amount;
                        stmt = c.prepareStatement("update account set balance=? where acc_number=?");
                        stmt.setDouble(1,newBal);
                        stmt.setString(2,fromAccount);
                        stmt.execute();

                        stmt = c.prepareStatement("select balance from account WHERE acc_number=? ");
                        stmt.setString(1,toAccount);
                        stmt.execute();
                        ResultSet rs = stmt.getResultSet();

                        if(rs.next()){
                            double tBalance = rs.getDouble("balance");
                            double newBala= amount+tBalance;
                            stmt=  c.prepareStatement("update account set balance=? where acc_number=?");
                            stmt.setDouble(1,newBala);
                            stmt.setString(2,toAccount);
                            stmt.execute();
                        }
                        System.out.println("Transfer is completely successfully!!!");
                    }
                    else{
                        System.out.println("Balance is not enough");
                        throw new Exception("your Balance is:"+" "+nbalance);
                    }
                }
            }
        }else {
            System.out.println("account is not active");
            throw new Exception("Bank account is not active!!!");
        }
    }
}
