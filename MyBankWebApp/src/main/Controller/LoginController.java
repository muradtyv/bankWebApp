package main.Controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import main.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    private BCrypt.Verifyer verifyer = BCrypt.verifyer();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        try{
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User u = userDao.findByEmail(email);

            if(u==null){
                throw new NullPointerException("User does not exist!!!!!");
            }

            BCrypt.Result result = verifyer.verify(password.toCharArray(),u.getPassword().toCharArray());

            if(!result.verified){
                throw new IllegalArgumentException("password is incorrect!!!!");
            }


            request.getSession().setAttribute("loggedUser",u);
            response.sendRedirect("view");
        }catch (Exception ex){
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }

    }
}
