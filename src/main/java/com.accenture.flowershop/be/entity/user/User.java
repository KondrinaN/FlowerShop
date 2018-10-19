package com.accenture.flowershop.be.entity.user;

public class User implements UserInterface{
    protected String login;
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
