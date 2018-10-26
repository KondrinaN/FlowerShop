package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.RowOrderDAOImpl;
import com.accenture.flowershop.be.entity.order.RowOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rowOrderBusinessService")
public class RowOrderBusinessServiceImpl implements  RowOrderBusinessService{

    @Autowired
    private RowOrderDAOImpl rowOrderDAO;

    public RowOrderBusinessServiceImpl()
    {
        System.out.println("rowOrderBusinessService");
    }

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
