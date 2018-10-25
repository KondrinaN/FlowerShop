package com.accenture.flowershop.be.entity.order;

import javax.persistence.*;

@Entity
@Table(name = "RowsOrders")
public class RowOrder implements RowOrderInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROWS_ORDERS_SEQ")
    @SequenceGenerator(name="ROWS_ORDERS_SEQ", sequenceName = "ROWS_ORDERS_SEQ", allocationSize = 1)
    private int idRowOrder;

    @OneToMany
    @JoinColumn(name = "idOrder")
    private int orderId;

    @Column(name = "NameProduct")
    private String nameProduct;

    @Column(name = "Count")
    private int count;

    @Column(name = "Price")
    private int price;

    public RowOrder()
    {}

    @Override
    public void setIdRowOrder(int id) {
        this.idRowOrder=id;
    }

    @Override
    public int getIdRowOrder() {
        return idRowOrder;
    }

    @Override
    public void setIdOrder(int orderId) {
        this.orderId =orderId;
    }

    @Override
    public int getIdOrder() {
        return orderId;
    }

    @Override
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setPrice(int price) {
        this.price=price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
