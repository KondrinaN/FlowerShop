package com.accenture.flowershop.be.entity.user;

import com.accenture.flowershop.fe.dto.CustomerDTO;
import com.accenture.flowershop.fe.enums.customer.UserShop;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name="USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    private int idUser;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Name")
    private String name;

    @Column(name = "Patronymic")
    private String patronymic;

    @Column(name = "Address")
    private String address;

    @Column(name = "CashBalance")
    private double cashBalance;

    @Column(name = "Discount")
    private int discount;

    @Column(name = "UserRole")
    private UserShop userRole;

    public Customer(){}

    public Customer(String login, String password){
        super(login, password);
    }

    public Customer(String login, String password, String surname, String name, String patronymic, String address, double cashBalance, int discount, UserShop userRole)
    {
        super(login, password);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.cashBalance = cashBalance;
        this.discount = discount;
        this.userRole = userRole;
    }

    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO)
    {
        if (customerDTO!= null)
        {
            return new Customer(customerDTO.getLogin(), customerDTO.getPassword(), customerDTO.getSurname(),
                    customerDTO.getName(), customerDTO.getPatronymic(), customerDTO.getAddress(),
                    customerDTO.getCashBalance(), customerDTO.getDiscount(), customerDTO.getUserRole());
        }
        return null;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
