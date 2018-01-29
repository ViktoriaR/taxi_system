package com.taxi_system.commands;

import com.taxi_system.variables.Variables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 11.01.2018.
 */
public class LogoutCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("user " + request.getSession().getAttribute(Variables.USER_NAME.getValue()) + " logged out");
        request.getSession().removeAttribute(Variables.USER_NAME.getValue());
        request.getSession().removeAttribute(Variables.ORDER_NAME.getValue());
        request.getSession().removeAttribute(Variables.SAVED_ORDER_NAME.getValue());
        return Variables.INDEX_PAGE.getValue();
    }
}
