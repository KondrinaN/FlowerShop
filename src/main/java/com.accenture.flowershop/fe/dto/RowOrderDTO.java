package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.order.RowOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RowOrderDTO {
    private int idRowOrder;
    private int orderId;
    private String nameProduct;
    private BigDecimal count;
    private BigDecimal price;

    public RowOrderDTO(){}

    public RowOrderDTO(String nameProduct, BigDecimal count, BigDecimal price) {
        this.idRowOrder = idRowOrder;
        this.orderId = orderId;
        this.nameProduct = nameProduct;
        this.count = count;
        this.price = price;
    }

    public static RowOrderDTO convertRowOrderToRowOrderDTO(RowOrder rowOrder)
    {
        if (rowOrder!= null)
            return new RowOrderDTO(rowOrder.getNameProduct(), rowOrder.getCount(), rowOrder.getPrice());

        return null;
    }

    public static List<RowOrderDTO> convertListRowOrderToListRowOrderDTO(List<RowOrder> rowOrders)
    {
        List<RowOrderDTO> rowsOrderDTO = new ArrayList<RowOrderDTO>();
        for (RowOrder row : rowOrders) {
            RowOrderDTO rowOrderDTO = convertRowOrderToRowOrderDTO(row);
            if(rowOrderDTO!=null)
                rowsOrderDTO.add(rowOrderDTO);
        }
        return rowsOrderDTO;
    }

    public int getIdRowOrder() {
        return idRowOrder;
    }

    public void setIdRowOrder(int idRowOrder) {
        this.idRowOrder = idRowOrder;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
