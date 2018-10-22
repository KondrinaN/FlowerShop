package com.accenture.flowershop.be.entity.user;

import javax.persistence.Column;

public class User implements UserInterface{
    @Column(name = "Login", unique = true)
    protected String login;

    @Column(name = "Password")
    protected String password;

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login){ this.login = login; }

    public String getLogin(){ return this.login; }

    public void setPassword(String password){ this.password = password;}
}
