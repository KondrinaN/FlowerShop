package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerDAOlmpl;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("flowerBusinessService")
public class FlowerBusinessServicelmpl implements FlowerBusinessService {

    @Autowired
    private FlowerDAOlmpl flowerDAO;

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
