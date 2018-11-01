package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("flowerDAOImpl")
public class FlowerDAOImpl implements FlowerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Flower> findAll() {
        try{
            TypedQuery<Flower> query = entityManager.createNamedQuery("Flowers.findAll", Flower.class);
            List<Flower> flowers= query.getResultList();
            return  flowers;
        }
        catch (NoResultException exc)
        {}
        return null;
    }

    @Override
    public Flower findFlowerById() {
        return null;
    }

    @Override
    public Flower findFlowerByName() {
        return null;
    }

    @Override
    public Flower findFlowerByRangePrice(double minPrice, double maxPrice) {
        return null;
    }

    @Override
    public Long save(Flower flower) {
        try {
         /*   EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();


            if (customer.getIdUser() == null)*/
            entityManager.persist(flower);
           /* else
                entityManager.merge(customer);

            entityManager.flush();
            transaction.commit();*/

            return flower.getId();
        }
        catch(NoResultException exc) {
            return new Long(0);
        }
    }

}
