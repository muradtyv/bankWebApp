
package main;

import java.sql.Connection;
import java.sql.DriverManager;


public abstract class Abstract {
    
     public static Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String root = "root";
        String password ="1234";
        Connection c = DriverManager.getConnection(url,root,password);
         return c;
        
    }
}
