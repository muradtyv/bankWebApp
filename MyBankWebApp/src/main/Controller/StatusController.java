package main.Controller;


import com.company.dao.inter.BankDaoInter;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StatusController", urlPatterns = "/status")
public class StatusController extends HttpServlet {

    private BankDaoInter bankDao= Context.instanceBankDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            String action = request.getParameter("element");
            if(action.equals("")) {
                int id = Integer.valueOf(request.getParameter("bid"));
                bankDao.updateStatus(id);
                request.getRequestDispatcher("accounts.jsp").forward(request, response);
            }else if(action.equals("status")){
                int id = Integer.valueOf(request.getParameter("id"));
                bankDao.updateStatus(id);
               request.getRequestDispatcher("myBankAccount.jsp").forward(request,response);
            }else if (action.equals("searchStatus")){
                int id = Integer.valueOf(request.getParameter("id"));
                bankDao.updateStatus(id);
                request.getRequestDispatcher("searchingaccounts.jsp").forward(request,response);
            }
        }catch (Exception ex ){
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }
    }
}
