package com.taxi_system.commands;

import com.taxi_system.services.ClientService;
import com.taxi_system.variables.Variables;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 09.01.2018.
 */
public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = new ClientService();
        String page;
        String login = request.getParameter(Variables.LOGIN_NAME.getValue());
        String password = request.getParameter(Variables.PASSWORD_NAME.getValue());
        String name = request.getParameter(Variables.NAME_NAME.getValue());

        try {
            if (StringUtils.isBlank(login) && StringUtils.isBlank(password)) {
                throw new Exception(Variables.BLANK_LOGIN_PASSWORD_EXCEPTION_MESSAGE.getValue());
            }
            clientService.addClient(login, password, name);
            request.getSession().setAttribute(Variables.USER_NAME.getValue(), login);
            page = Variables.INDEX_PAGE.getValue();
            logger.info("new user " + login + "registered");
        } catch (Exception e) {
            request.setAttribute(Variables.EXCEPTION_NAME.getValue(), e.getMessage());
            request.setAttribute(Variables.LOGIN_NAME.getValue(), login);
            request.setAttribute(Variables.NAME_NAME.getValue(), name);
            page = Variables.REGISTRATION_FORM_PAGE.getValue();
            logger.info(e.getMessage());
        }

        return page;
    }
}
