package main.Controller;

import com.company.dao.inter.BankDaoInter;
import com.company.dao.inter.TransactionDaoInter;
import com.company.entity.BankAccount;
import com.company.entity.Transaction;
import main.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransferController", urlPatterns = "/transfer")
public class TransferController extends HttpServlet {

    private BankDaoInter bankDao = Context.instanceBankDao();
    private  BankAccount bankAccount = new BankAccount();
    private TransactionDaoInter transactionDao = Context.instanceTransactionDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("transfer.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String fAccount = request.getParameter("fAccount");
            String tAccount = request.getParameter("tAccount");
            double amount =Double.parseDouble( request.getParameter("amount"));

            bankDao.transfer(fAccount,tAccount,amount);

            Transaction transaction = new Transaction(id,fAccount,tAccount,amount);

            transactionDao.insert(transaction);
            response.sendRedirect("alltransaction");
        }catch (Exception ex){
            response.sendRedirect("error?msg=transfer is failed!!!!");
        }
    }
}
