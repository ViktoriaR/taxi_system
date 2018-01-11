package com.taxi_system.commands;

import com.taxi_system.services.ClientService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 02.01.2018.
 */
public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = new ClientService();
        String page;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (StringUtils.isNotBlank(login) && StringUtils.isNotBlank(password) && clientService.checkClient(login, password)) {
            request.getSession().setAttribute("username", login);
            page = "/index.jsp";
        } else {
            request.setAttribute("loginFailedMessage", "Login failed! Please try again!");
            request.setAttribute("login", login);
            page = "/jsp/loginForm.jsp";
        }

        return page;
    }
}
