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
 * Created by Victoria on 02.01.2018.
 */
public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = new ClientService();
        String page;
        String login = request.getParameter(Variables.LOGIN_NAME.getValue());
        String password = request.getParameter(Variables.PASSWORD_NAME.getValue());

        if (StringUtils.isNotBlank(login) && StringUtils.isNotBlank(password) && clientService.checkClient(login, password)) {
            request.getSession().setAttribute(Variables.USER_NAME.getValue(), login);
            page = Variables.INDEX_PAGE.getValue();
            logger.info("user " + login + " logged in");
        } else {
            request.setAttribute(Variables.EXCEPTION_NAME.getValue(), Variables.LOG_IN_EXCEPTION_MESSAGE.getValue());
            request.setAttribute(Variables.LOGIN_NAME.getValue(), login);
            page = Variables.LOGIN_FORM_PAGE.getValue();
            logger.info("user failed to log in with login = " + login + ", password = " + password);
        }

        return page;
    }
}
