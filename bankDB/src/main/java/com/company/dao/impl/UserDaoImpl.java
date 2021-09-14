package com.company.dao.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import main.Abstract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl extends Abstract implements UserDaoInter {

    private static User getUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        User u = new User(id, name, surname, email);
        return u;
    }

    private static User getSimpleUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        User u = new User(id, name, surname, email);
        u.setPassword(rs.getString("password"));
        return u;
    }
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("select * from user");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?, surname=?, email=? where id=? ");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, String.valueOf(u.getId()));

            return stmt.execute();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
private BCrypt.Hasher crypt = BCrypt.withDefaults();
    @Override
    public boolean addUser(User u) {
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("INSERT into user (name,surname,email,password) VALUES(?,?,?,?) ");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4,crypt.hashToString(4,u.getPassword().toCharArray()));
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("delete from user where id=" + id);
            return stmt.execute();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User getById(int id) {
        User u = null;
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("select * from user where id=" + id);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                u = getUser(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public User findEmailAndPassword(String email, String password) {
        User u= null;
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=? and password=?");
            stmt.setString(1,email);
            stmt.setString(2,password );
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                 u = getSimpleUser(rs);

            }
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    @Override
    public User findByEmail(String email) {
        User u= null;
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=? ");
            stmt.setString(1,email);
          ;
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                u = getSimpleUser(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }
    @Override
    public boolean signUp(User user) throws Exception{
        boolean done = !user.getName().equals("") && !user.getSurname().equals("") && !user.getEmail().equals("") && !user.getPassword().equals("") && user.getPassword().equals(user.getRePassword());
        if (done) {
            try (Connection c = connect();) {
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("select email from user where email='" + user.getEmail() + "'");
                done = done && !rs.next();
                if (!done) {
                  throw new IllegalArgumentException("User is exist!!");
                }
            }
        }
        return done;
    }

}
