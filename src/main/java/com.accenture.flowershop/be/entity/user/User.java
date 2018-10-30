package com.accenture.flowershop.be.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class User implements UserInterface{
    @Column(name = "Login", unique = true)
    protected String login;

    @Column(name = "Password")
    protected String password;

    public User() {
    }


    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
