package com.accenture.flowershop.fe.ws;

import com.accenture.flowershop.be.access.FlowerDAO;
import com.accenture.flowershop.be.business.FlowerBusinessService;
import com.accenture.flowershop.be.business.FlowerBusinessServiceImpl;
import com.accenture.flowershop.be.entity.flower.Flower;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;


public class FlowerStockWebServiceImpl implements FlowerStockWebService2 {

    private static final Logger LOG = 	LoggerFactory.getLogger(FlowerStockWebServiceImpl.class);

    @Autowired
    private FlowerBusinessService flowerBusinessService;

    @Autowired
    private FlowerDAO flowerDAO;

    public FlowerStockWebServiceImpl()
    {
        LOG.info("SERVICE RUN!!!");
    }

    @Override
    @Transactional
    public void increaseFlowersStockSize(BigDecimal balance) throws java.lang.Exception {
        List<Flower> flowers = flowerBusinessService.findAllFlowers();

        for(Flower f:flowers)
        {
            BigDecimal nowBalance = f.getBalance();
            flowerDAO.addFlowers(f, nowBalance.add(balance));
        }
    }
}
