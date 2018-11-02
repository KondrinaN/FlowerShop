package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
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
        {
            return null;
        }
    }

    @Override
    public Flower findFlowerById() {
        return null;
    }

    @Override
    public List<Flower> findFlowerByName(String nameFlower) {
        try{
            TypedQuery<Flower> query = entityManager.createNamedQuery("Flowers.findFlowerByName", Flower.class).setParameter("nameFlower", nameFlower);
            return query.getResultList();
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }

    @Override
    public List<Flower> findFlowerByRangePrice(BigDecimal minPrice, BigDecimal maxPrice) {
        try{
            TypedQuery<Flower> query = entityManager.createNamedQuery("Flowers.findFlowerByRangePrice", Flower.class);

            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);
            return query.getResultList();
        }
        catch (NoResultException exc)
        {
            return null;
        }
    }

    @Override
    public Long save(Flower flower) throws Exception {

            if (flower.getId()==null) {
                entityManager.persist(flower);

                return flower.getId();
            }
            else
                throw new Exception("User was not created!");
    }

}
