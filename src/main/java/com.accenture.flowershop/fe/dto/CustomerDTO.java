package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.customer.UserShop;

public class CustomerDTO {

    private int idUser;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private double cashBalance;
    private int discount;
    private UserShop userRole;

    public CustomerDTO()
    {

    }

    public CustomerDTO(String login, String password, String surname, String name, String patronymic, String address, double cashBalance, int discount, UserShop userRole)
    {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.cashBalance = cashBalance;
        this.discount = discount;
        this.userRole = userRole;
    }

    public CustomerDTO convertCustomerToCustomerDTO(Customer customer)
    {
        if (customer!= null)
        {
            return new CustomerDTO(customer.getLogin(), customer.getPassword(), customer.getSurname(),
                    customer.getName(), customer.getPatronymic(), customer.getAddress(),
                    customer.getCashBalance(), customer.getDiscount(), customer.getUserRole());
        }
        return null;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public UserShop getUserRole() {
        return userRole;
    }

    public void setUserRole(UserShop userRole) {
        this.userRole = userRole;
    }

}
