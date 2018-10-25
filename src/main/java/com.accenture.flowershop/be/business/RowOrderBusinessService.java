package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.RowOrder;

import java.util.List;

public interface RowOrderBusinessService {
    void saveRowOrder(int idOrder);
    List<RowOrder> findAllRowOrder(int idOrder);
    void deleteRowOrder(int idOrder);
}
