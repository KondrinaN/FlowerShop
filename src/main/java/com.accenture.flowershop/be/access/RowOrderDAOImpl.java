package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.order.RowOrder;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("rowOrderDAOImpl")
public class RowOrderDAOImpl implements RowOrderDAO {

    @Override
    public List<RowOrder> findAll() {
        return null;
    }

    @Override
    public RowOrder findRowOrderById() {
        return null;
    }

    @Override
    public int save(int idOrder) {
        return 0;
    }

    @Override
    public int update(int idOrder) {
        return 0;
    }

    @Override
    public int delete(int idOrder) {
        return 0;
    }
}