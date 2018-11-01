package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;

import java.util.List;

public interface FlowerDAO {
    List<Flower> findAll();
    Flower findFlowerById();
    List<Flower> findFlowerByName(String nameFlower);
    List<Flower> findFlowerByRangePrice(double minPrice, double maxPrice);
    Long save(Flower flower) throws Exception;
}
