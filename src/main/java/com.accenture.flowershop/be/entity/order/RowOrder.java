package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.fe.dto.RowOrderDTO;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private BigDecimal count;

    @Column(name = "Price")
    private BigDecimal price;

    public RowOrder(){}

    public RowOrder(String nameProduct, BigDecimal count, BigDecimal price) {

        this.nameProduct = nameProduct;
        this.count = count;
        this.price = price;
    }


    public static RowOrder convertRowOrderDTOToRowOrder(RowOrderDTO rowOrderDTO)
    {
        if (rowOrderDTO!= null)
            return new RowOrder(rowOrderDTO.getNameProduct(), rowOrderDTO.getCount(), rowOrderDTO.getPrice());

        return null;
    }

    public static List<RowOrder> convertListRowOrderToListRowOrderDTO(List<RowOrderDTO> rowOrders)
    {
        List<RowOrder> rowsOrder = new ArrayList<RowOrder>();
        for (RowOrderDTO row : rowOrders) {
            RowOrder rowOrder = convertRowOrderDTOToRowOrder(row);
            if(rowOrder!=null)
                rowsOrder.add(rowOrder);
        }
        return rowsOrder;
    }

    @Override
    public String getPriceToString()
    {
        return price.toString();
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
    public void setCount(BigDecimal count) {
        this.count = count;
    }

    @Override
    public BigDecimal getCount() {
        return count;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price=price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
