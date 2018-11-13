package com.accenture.flowershop.cg.services.rest;

import com.accenture.flowershop.be.access.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/checkLoginExist")
public class LoginExistService {

    @Autowired
    private UserDAO userDAO;

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/check")
    public boolean existLogin(String login)
    {

        //String logIn = login.substring(login.indexOf('='), login.length());
        try {

            if (userDAO.findCustomerByLogin(login) != null)
                return true;
        }
        catch (Exception exc)
        {
        }

        return false;
    }
}
