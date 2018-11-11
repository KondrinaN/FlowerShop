package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Customer;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface UserMarshallingService {

    void convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException;
    Object convertFromXMLToObject(String xmlfile) throws IOException, JAXBException;
}
