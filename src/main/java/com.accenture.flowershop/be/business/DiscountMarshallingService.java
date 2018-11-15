package com.accenture.flowershop.be.business;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface DiscountMarshallingService {

    String convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException;
    Object convertFromXMLToObject(String xmlfile) throws IOException, JAXBException;
    void addCustomerInQueue(String message, String nameQueue);
}
