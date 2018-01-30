package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.facade.OrderFacade;
import com.taxi_system.variables.Variables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 16.01.2018.
 */
public class ProcessOrderCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        Orders order = (Orders) request.getSession().getAttribute(Variables.ORDER_NAME.getValue());
        String username = (String) request.getSession().getAttribute(Variables.USER_NAME.getValue());
        if (order == null) {
            page = Variables.ORDER_FORM_PAGE.getValue();
            logger.info("user " + username + " try to submit order without creating it");
        } else {
            try {
                OrderFacade.processOrder(order);
                request.getSession().removeAttribute(Variables.ORDER_NAME.getValue());
                request.getSession().setAttribute(Variables.SAVED_ORDER_NAME.getValue(), order);
                response.sendRedirect(Variables.ORDER_DETAILS_COMMAND.getValue());
                page = null;
                logger.info("user " + username + " submit order");
            } catch (Exception e) {
                request.setAttribute(Variables.EXCEPTION_NAME.getValue(), e.getMessage());
                page = Variables.PRICE_PAGE.getValue();
                logger.error("user " + username + " failed to submit order, " + e.getMessage());
            }
        }

        return page;
    }
}
