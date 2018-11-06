package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public interface FlowerBusinessService {

    List<Flower> findAllFlowers();
    Flower findFlowerById(int idFlower);
    void deleteFlower(int idFlower);
    List<Flower> findFlowerByName(String nameFlower);
    List<Flower> findFlowerByRangePrice(BigDecimal minPrice, BigDecimal maxPrice);
    void OutFoundFlower(List<Flower> flowers, HttpServletRequest request);
    public int getLengthListFlowers();
    public Flower getFlowerById(int id);
    public List<Flower> getFlowers();
}
