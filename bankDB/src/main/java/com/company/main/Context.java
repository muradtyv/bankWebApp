package main;

import com.company.dao.impl.BankDaoImpl;
import com.company.dao.impl.TransactionDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.BankDaoInter;
import com.company.dao.inter.TransactionDaoInter;
import com.company.dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    public static BankDaoInter instanceBankDao(){
        return new BankDaoImpl();
    }
    public static TransactionDaoInter instanceTransactionDao(){
        return new TransactionDaoImpl();
    }
}
