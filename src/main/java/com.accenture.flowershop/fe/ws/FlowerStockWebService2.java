package com.accenture.flowershop.fe.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.math.BigDecimal;

@WebService
public interface FlowerStockWebService2 {

    void increaseFlowersStockSize(@WebParam(name = "balance") BigDecimal balance) throws java.lang.Exception;
}
