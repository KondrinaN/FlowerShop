package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.enums.customer.UserShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

@Service("userBusinessService")
public class UserBusinessServiceImpl implements UserBusinessService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMarshallingService userMarshallingService;

    private Map<String, Customer> users;
    private List<Customer> customers;

    private static final Logger LOG = 	LoggerFactory.getLogger(UserBusinessServiceImpl.class);

    public UserBusinessServiceImpl()
    {
        users = new HashMap<String, Customer>();

       // LOG.debug("User");
        //System.out.println("userBusinessService");
    }



    public void DeleteUserInMap(String loginUser)
    {
        for(Iterator<Map.Entry<String, Customer>> it = users.entrySet().iterator(); it.hasNext(); )
        {
            Map.Entry<String, Customer> entry = it.next();
            if(entry.getKey().equals(loginUser)) {
                it.remove();
            }
        }
    }

    @Override
    public Customer logIn(String login, String password) throws Exception {
        //customers = userDAO.findAll();
        Customer customer = userDAO.findCustomerByLogin(login);

        if(customer!=null) {
            if (checkPassword(password, customer.getPassword()))
                return customer;
            else
                throw new Exception("Wrong password!");
        }
        else
            throw new Exception("User not registered!");

        /*if (users.size()!=0) {
            if (users.containsKey(login)) {

                return users.get(login);
            }
        }*/
    }

    @Override
    @Transactional
    public Customer updateCashBalance(Customer customer, BigDecimal cash) throws Exception
    {
        return userDAO.updateCashBalance(customer, cash);
    }

    @Override
    public void customerOXMUsage(Customer customer) throws JAXBException {
        try {
             //загружаем properties
            Properties properties = new Properties();
            InputStream propertyInputStream =
                    getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(propertyInputStream);

            String path= properties.getProperty("customer.xml.path");

            //Создаем xml файл
            userMarshallingService.convertFromObjectToXML(customer, path);

            Customer customer1 = (Customer)userMarshallingService.convertFromXMLToObject(path);
            FileInputStream xmlInputStream = new FileInputStream(path);

            //Закрываем соединения
            propertyInputStream.close();
            xmlInputStream.close();
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }

    @Override
    @Transactional
    public Customer register(String login, String password, String surname, String name, String patronymic, String address, BigDecimal cashBalance, BigDecimal discount, UserShop userRole)
            throws Exception{
        customers = userDAO.findAll();
        Customer customer = userDAO.findCustomerByLogin(login);

        if(customer==null)
        {
           customer= new Customer(null, login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

           customer.setIdUser(userDAO.save(customer));
           if (customer.getIdUser()!=0)
               customers.add(customer);

           if (customer!=null) {
               customerOXMUsage(customer);
               return customer;
           }
           else
               throw new Exception("User not registered!");
        }
        else
            throw new Exception("User with this login is already registered!");

      /*  if (!users.containsKey(login)) {
            Customer customer = new Customer(login, password, surname, name, patronymic, address, cashBalance, discount, userRole);

            users.put(customer.getLogin(), customer);
            return customer;
        }*/
    }

    @Override
    public boolean checkPassword(String passwordCurrent, String passwordCustomer) {
        if(passwordCustomer.equals(passwordCurrent))
            return true;
        return false;
    }


}
