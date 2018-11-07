package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.customer.UserShop;

import java.math.BigDecimal;

public class CustomerDTO {

    private Long idUser;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private BigDecimal cashBalance;
    private BigDecimal discount;
    private UserShop userRole;

    public CustomerDTO()
    {

    }

    public CustomerDTO(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public CustomerDTO(Long idUser, String login, String password, String surname, String name, String patronymic, String address, BigDecimal cashBalance, BigDecimal discount, UserShop userRole)
    {
        this.idUser = idUser;
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

    public static CustomerDTO convertCustomerToCustomerDTO(Customer customer)
    {
        if (customer!= null)
        {
            return new CustomerDTO(customer.getIdUser(), customer.getLogin(), customer.getPassword(), customer.getSurname(),
                    customer.getName(), customer.getPatronymic(), customer.getAddress(),
                    customer.getCashBalance(), customer.getDiscount(), customer.getUserRole());
        }
        return null;
    }


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
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

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public UserShop getUserRole() {
        return userRole;
    }

    public void setUserRole(UserShop userRole) {
        this.userRole = userRole;
    }

}
