package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("flowerDAOImpl")
public class FlowerDAOImpl implements FlowerDAO {

    @Override
    public List<Flower> findAll() {
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

}
