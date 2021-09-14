package main.Controller;

import com.company.dao.inter.BankDaoInter;
import com.company.entity.BankAccount;
import main.Context;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "BankRegisterController", urlPatterns = "/bregister")
public class BankRegisterController extends HttpServlet {

    private BankDaoInter bankDao = Context.instanceBankDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("bankRegister.jsp").forward(request,response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{


        String email = request.getParameter("Nemail");
        String customer_name = request.getParameter("customer_name");
        String exchange = request.getParameter("exchange");
        String accNumber = request.getParameter("account_number");
        double balance = Double.valueOf(request.getParameter("balance"));
        String status = request.getParameter("status");

        BankAccount bankAccount = new BankAccount(0,customer_name,exchange,accNumber,balance,status,email);


           if(!bankDao.bankAccountIsExist(accNumber)){
               bankDao.insertAccount(bankAccount);

               request.getSession().setAttribute("bankAccount", bankAccount);
               response.sendRedirect("allview");
           }else{
               response.sendRedirect("error?msg=Register is exist!");
           }
        }
}
