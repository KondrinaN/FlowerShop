package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerDAO;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlowerBusinessServicelmpl implements FlowerBusinessService {

    @Autowired
    protected FlowerDAO flowerDAO;

    @Override
    public List<Flower> findAllFlowers() {
        return null;
    }

    @Override
    public Flower findFlowerById(int idFlower) {
        return null;
    }

    @Override
    public void deleteFlower(int idFlower) {

    }
}
