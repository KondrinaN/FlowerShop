package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.order.StatusOrder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Orders")
@NamedQueries(
        {
                @NamedQuery(name = "Orders.findAllByUser_Id",
                        query = "SELECT o FROM Order o WHERE o.users_Id = :users_Id"),

                @NamedQuery(name = "Orders.findAll",
                        query = "SELECT o FROM Order o")
        }
)
public class Order implements OrderInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;


    @ManyToOne
    @JoinColumn(name = "Users_Id")
    private Customer users_Id;

    @Column(name = "Status")
    private StatusOrder status;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "DateCreate")
    private Date dateCreate;

    @Column(name = "DateClose")
    private Date dateClose;

    public Order(){}

    public Order(Customer users_Id, StatusOrder status, BigDecimal amount, Date dateCreate, Date dateClose) {

        this.users_Id = users_Id;
        this.status = status;
        this.amount = amount;
        this.dateCreate = dateCreate;
        this.dateClose = dateClose;
    }

    @Override
    public void setIdOrder(Long id) {
        this.idOrder = id;
    }

    @Override
    public Long getIdOrder() {
        return idOrder;
    }

    @Override
    public void setUsersId(Customer users_Id) {
        this.users_Id = users_Id;
    }

    @Override
    public Customer getUsersId() {
        return users_Id;
    }

    @Override
    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    @Override
    public StatusOrder getStatus() {
        return status;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public Date getDateCreate() {
        return dateCreate;
    }

    @Override
    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Override
    public Date getDateClose() {
        return dateClose;
    }
}
