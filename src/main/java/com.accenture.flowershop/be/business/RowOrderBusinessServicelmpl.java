package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.RowOrderDAO;
import com.accenture.flowershop.be.entity.order.RowOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RowOrderBusinessServicelmpl implements  RowOrderBusinessService{

    @Autowired
    protected RowOrderDAO rowOrderDAO;

    @Override
    public void saveRowOrder(int idOrder) {

    }

    @Override
    public List<RowOrder> findAllRowOrder(int idOrder) {
        return null;
    }

    @Override
    public void deleteRowOrder(int idOrder) {

    }
}
