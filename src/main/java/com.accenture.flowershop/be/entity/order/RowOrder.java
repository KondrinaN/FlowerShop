package com.accenture.flowershop.be.entity.order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RowsOrders")
public class RowOrder implements RowOrderInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRowOrder;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Order orderId;

    @Column(name = "NameProduct")
    private String nameProduct;

    @Column(name = "Count")
    private int count;

    @Column(name = "Price")
    private int price;

    public RowOrder(){}

    public RowOrder(String nameProduct, int count, int price) {
        this.idRowOrder = idRowOrder;
        this.nameProduct = nameProduct;
        this.count = count;
        this.price = price;
    }



    @Override
    public void setIdRowOrder(Long id) {
        this.idRowOrder=id;
    }

    @Override
    public Long getIdRowOrder() {
        return idRowOrder;
    }

    @Override
    public Order getOrderId() { return orderId; }

    @Override
    public void setOrderId(Order orderId) { this.orderId = orderId;
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
