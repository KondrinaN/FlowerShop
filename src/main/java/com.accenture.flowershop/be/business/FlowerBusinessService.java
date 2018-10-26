package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;

import java.util.List;

public interface FlowerBusinessService {

    List<Flower> findAllFlowers();
    Flower findFlowerById(int idFlower);
    void deleteFlower(int idFlower);
}
