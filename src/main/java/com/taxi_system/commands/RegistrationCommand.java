package com.taxi_system.commands;

import com.taxi_system.services.ClientService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 09.01.2018.
 */
public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = new ClientService();
        String page;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        try {
            if (StringUtils.isBlank(login) && StringUtils.isBlank(password)) {
                throw new Exception("Enter login and password");
            }
            clientService.addClient(login, password, name);
            request.getSession().setAttribute("username", login);
            page = "/index.jsp";
        } catch (Exception e) {
            request.setAttribute("registrationFailedMessage", e.getMessage());
            request.setAttribute("login", login);
            request.setAttribute("name", name);
            page = "/jsp/registrationForm.jsp";
        }

        return page;
    }
}
