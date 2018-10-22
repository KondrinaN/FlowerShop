package com.accenture.flowershop.be.entity.order;

import javax.persistence.*;

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
    public void SetIdRowOrder(int id) {
        this.idRowOrder=id;
    }

    @Override
    public int GetIdRowOrder() {
        return idRowOrder;
    }

    @Override
    public void SetIdOrder(int orderId) {
        this.orderId =orderId;
    }

    @Override
    public int GetIdOrder() {
        return orderId;
    }

    @Override
    public void SetNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public String GetNameProduct() {
        return nameProduct;
    }

    @Override
    public void SetCount(int count) {
        this.count = count;
    }

    @Override
    public int GetCount() {
        return count;
    }

    @Override
    public void SetPrice(int price) {
        this.price=price;
    }

    @Override
    public int GetPrice() {
        return price;
    }
}
