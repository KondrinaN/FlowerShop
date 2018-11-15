package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.entity.user.ChangeDiscount;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Service("discountMarshallingService")
public class DiscountMarshallingServiceImpl implements DiscountMarshallingService {

    private Marshaller marshaller;

    private Unmarshaller unmarshaller;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private UserBusinessService userBusinessService;

    @Override
    public String convertFromObjectToXML(Object object, String filepath) throws IOException, JAXBException {
        FileOutputStream os = null;
        try {
            JAXBContext context = JAXBContext.newInstance(ChangeDiscount.class);
            marshaller = context.createMarshaller();
            os = new FileOutputStream(filepath);
            marshaller.marshal(object, new StreamResult(os));

            //запись в очередь jms
            StringWriter mes=new StringWriter();
            marshaller.marshal(object, mes);
            return mes.toString();
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
            JAXBContext context = JAXBContext.newInstance(ChangeDiscount.class);
            unmarshaller = context.createUnmarshaller();
            StringReader stringReader = new StringReader(xmlfile);
            return unmarshaller.unmarshal(stringReader);
        }
        finally {
            if (is!=null)
                is.close();
        }
    }

    public void addCustomerInQueue(String message, String nameQueue)
    {
        try
        {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue(nameQueue);
            TextMessage textMessage = session.createTextMessage(message);

            MessageProducer producer = session.createProducer(queue);
            producer.send(textMessage);

            connection.close();
        }
        catch(JMSException ex)
        {

        }
    }

    @PostConstruct
    public void discountFromQueue() {
        try
        {
            Connection connection = connectionFactory.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue("IN_QUEUE");
            MessageConsumer consumer = session.createConsumer(queue);

            connection.start();

            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String discountMessage = textMessage.getText();
                        if (!discountMessage.isEmpty())
                            userBusinessService.changeDiscount((ChangeDiscount)convertFromXMLToObject(discountMessage));
                    }
                    catch(JMSException e)
                    {}
                    catch (IOException e)
                    {}
                    catch (JAXBException e)
                    {}
                }
            });

            //connection.close();
        }
        catch(JMSException ex)
        {

        }
    }
}
