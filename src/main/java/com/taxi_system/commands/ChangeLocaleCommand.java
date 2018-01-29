package com.taxi_system.commands;

import com.taxi_system.variables.Variables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 24.01.2018.
 */
public class ChangeLocaleCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter(Variables.LOCALE_NAME.getValue());
        request.getSession().setAttribute(Variables.LOCALE_NAME.getValue(), locale);
        String page = request.getParameter(Variables.PAGE_NAME.getValue());
        logger.info("locale changed to " + locale);
        return page;
    }
}
