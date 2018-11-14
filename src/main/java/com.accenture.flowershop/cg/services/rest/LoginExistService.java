package com.accenture.flowershop.cg.services.rest;

import com.accenture.flowershop.be.access.UserDAO;
import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/checkLoginExist")
public class LoginExistService {

    @Autowired
    private UserDAO userDAO;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/check/{login}")
    public boolean existLogin(@PathParam("login") String login)
    {
        Customer customer = null;
        try {
            customer = userDAO.findCustomerByLogin(login);
        }
        catch (Exception exc)
        {
        }

        if (customer != null)
            return true;
        return false;
    }
}
