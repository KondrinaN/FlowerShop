package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.RowOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository("rowOrderDAOImpl")

public class RowOrderDAOImpl implements RowOrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RowOrder> findAll(Long idOrder, Order order) {
        try{
            TypedQuery<RowOrder> query = entityManager.createNamedQuery("RowsOrders.findAll", RowOrder.class).setParameter("orderId", order);
            List<RowOrder> rowOrders = query.getResultList();
            return rowOrders;
        }
        catch (NoResultException exc)
        {
            return null;
        }
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
