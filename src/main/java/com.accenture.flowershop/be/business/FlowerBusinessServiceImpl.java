package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerDAO;
import com.accenture.flowershop.be.access.FlowerDAOImpl;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("flowerBusinessService")
public class FlowerBusinessServiceImpl implements FlowerBusinessService {

    private static final Logger LOG = 	LoggerFactory.getLogger(FlowerBusinessServiceImpl.class);

    @Autowired
    private FlowerDAO flowerDAO;

    private List<Flower> flowers;


    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public int getLengthListFlowers()
    {
        return flowers.size();
    }

    @Override
    public Flower getFlowerById(int id) {
        return flowers.get(id);
    }



    public FlowerBusinessServiceImpl(){
        flowers= new ArrayList<Flower>();
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
    public List<Flower> findFlowerByRangePrice(BigDecimal minPrice, BigDecimal maxPrice) {

        return flowerDAO.findFlowerByRangePrice(minPrice, maxPrice);
    }

    @Override
    public void OutFoundFlower(List<Flower> flowers, HttpServletRequest request)
    {
        if (flowers.size() != 0) {
            for (Flower f : flowers) {
                request.setAttribute("idFlower", f.getId().toString());
                request.setAttribute("nameFlower", f.getNameFlower());
                request.setAttribute("balance", f.getBalance());
                request.setAttribute("price", f.getPrice());
                request.setAttribute("flowerAvailability", f.getFlowerAvailability());
            }

            request.setAttribute("flowers", flowers);
            this.setFlowers(flowers);
        } else
            request.setAttribute("Error", "Flowers not found!");
    }
}
