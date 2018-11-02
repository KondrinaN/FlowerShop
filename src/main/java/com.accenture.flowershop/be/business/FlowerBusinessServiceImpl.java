package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerDAO;
import com.accenture.flowershop.be.access.FlowerDAOImpl;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("flowerBusinessService")
public class FlowerBusinessServiceImpl implements FlowerBusinessService {

    private static final Logger LOG = 	LoggerFactory.getLogger(FlowerBusinessServiceImpl.class);

    @Autowired
    private FlowerDAO flowerDAO;

    public FlowerBusinessServiceImpl(){
        //System.out.println("flowerBusinessService");
       // LOG.debug("Flower");
    }

    @Override
    public List<Flower> findAllFlowers() {
        return flowerDAO.findAll();
    }

    @Override
    public Flower findFlowerById(int idFlower) {
        return null;
    }

    @Override
    public void deleteFlower(int idFlower) {

    }

    @Override
    public List<Flower> findFlowerByName(String nameFlower) {
        return flowerDAO.findFlowerByName(nameFlower);
    }

    @Override
    public List<Flower> findFlowerByRangePrice(double minPrice, double maxPrice) {
        return flowerDAO.findFlowerByRangePrice(minPrice, maxPrice);
    }


}
