package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service("userMarshallingService")
public class UserMarshallingServiceImpl implements UserMarshallingService {

    private Marshaller marshaller;

    private Unmarshaller unmarshaller;

    @Override
    public void convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException {
        FileOutputStream os = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Customer.class);
            marshaller = context.createMarshaller();
            os = new FileOutputStream(filepath);
            marshaller.marshal(object, new StreamResult(os));
        }
        finally {
            if (os!=null)
                os.close();
        }
    }

    @Override
    public Object convertFromXMLToObject(String xmlfile) throws IOException, JAXBException {
        FileInputStream is = null;
        try{
            JAXBContext context = JAXBContext.newInstance(Customer.class);
            unmarshaller = context.createUnmarshaller();
            is = new FileInputStream(xmlfile);
            return unmarshaller.unmarshal(new StreamSource(is));
        }
        finally {
            if (is!=null)
                is.close();
        }
    }
}
