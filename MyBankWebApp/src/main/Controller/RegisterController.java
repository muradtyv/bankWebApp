package main.Controller;


import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import main.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = "/register")
public class RegisterController extends HttpServlet {

private UserDaoInter userDao = Context.instanceUserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("register.jsp").forward(request,response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");

        User user = new User(0,name,surname,email,password,rePassword);

       try{
           if(userDao.signUp(user)){
               userDao.addUser(user);
               request.setAttribute("registeredUser",user );
               response.sendRedirect("login");

           }else{
              response.sendRedirect("that is not correct!!");
           }
       }catch (Exception e){
           response.sendRedirect("User exist!!");
       }
    }
}
