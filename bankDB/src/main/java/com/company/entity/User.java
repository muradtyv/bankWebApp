
package com.company.entity;


public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String rePassword;

    public User() {
    }

    public User(int id, String name, String surname, String email, String password, String rePassword) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public User(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    public User(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String password1) {
        this.rePassword = password1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email +  '}';
    }
    
}
