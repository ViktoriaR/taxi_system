package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.facade.OrderFacade;
import com.taxi_system.variables.Variables;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 16.01.2018.
 */
public class ProcessOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        Orders order = (Orders) request.getSession().getAttribute(Variables.ORDER_NAME.getValue());
        if (order == null) {
            page = Variables.ORDER_FORM_PAGE.getValue();
        } else {
            try {
                OrderFacade.processOrder(order);
                request.getSession().removeAttribute(Variables.ORDER_NAME.getValue());
                request.getSession().setAttribute(Variables.SAVED_ORDER_NAME.getValue(), order);
                response.sendRedirect(Variables.ORDER_DETAILS_COMMAND.getValue());
                page = null;
            } catch (Exception e) {
                request.setAttribute(Variables.EXCEPTION_NAME.getValue(), e.getMessage());
                page = Variables.PRICE_PAGE.getValue();
            }
        }

        return page;
    }
}
