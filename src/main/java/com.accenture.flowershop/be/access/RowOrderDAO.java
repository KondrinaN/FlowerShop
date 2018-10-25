package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.order.RowOrder;
import java.util.List;

public interface RowOrderDAO {
    List<RowOrder> findAll();
    RowOrder findRowOrderById();
    int save(int idOrder);
    int update(int idOrder);
    int delete(int idOrder);
}
