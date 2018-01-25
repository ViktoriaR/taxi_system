package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.facade.OrderFacade;
import com.taxi_system.services.DistanceService;
import com.taxi_system.services.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Victoria on 16.01.2018.
 */
public class ProcessOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        Orders order = (Orders) request.getSession().getAttribute("order");
        try {
            OrderFacade.processOrder(order);
            request.getSession().removeAttribute("order");
            request.getSession().setAttribute("savedOrder", order);
            page = "/jsp/details.jsp";
        } catch (Exception e) {
            request.setAttribute("exception", e.getMessage());
            page = "/jsp/price.jsp";
        }

        return page;
    }
}
