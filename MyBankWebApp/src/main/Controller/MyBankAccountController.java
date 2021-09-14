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

@WebServlet(name = "MyBankAccountController", urlPatterns = "/mybank")
public class MyBankAccountController extends HttpServlet {
    private BankDaoInter bankDao = Context.instanceBankDao();

   private BankAccount bankAccount = new BankAccount();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("myBankAccount.jsp").forward(request,response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

      try{
          String action = request.getParameter("element");
          int id = Integer.parseInt(request.getParameter("id"));
          if(action.equals("status")){
              bankDao.updateStatus(id);
          }else if(action.equals("delete")){
              bankDao.delete(id);
          }
          request.getRequestDispatcher("myBankAccount.jsp");
      }catch (Exception ex){
          ex.printStackTrace();
          response.sendRedirect("error?msg+"+ex.getMessage());
      }
    }
}
