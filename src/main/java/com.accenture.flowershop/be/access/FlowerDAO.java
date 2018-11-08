package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.flower.Flower;

import java.math.BigDecimal;
import java.util.List;

public interface FlowerDAO {
    List<Flower> findAll();
    Flower findFlowerById();
    List<Flower> findFlowerByName(String nameFlower);
    List<Flower> findFlowerByRangePrice(BigDecimal minPrice, BigDecimal maxPrice);
    Long save(Flower flower, BigDecimal count) throws Exception;
}
