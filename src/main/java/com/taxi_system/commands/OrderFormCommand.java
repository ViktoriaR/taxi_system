package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.services.CarTypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 11.01.2018.
 */
public class OrderFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from, to;
        Object order = request.getSession().getAttribute("order");
        if (order == null) {
            from = "From?";
            to = "To?";
        } else {
            from = ((Orders) order).getFromAddress();
            to = ((Orders) order).getToAddress();
        }

        CarTypeService carTypeService = new CarTypeService();
        request.setAttribute("carTypes", carTypeService.getCarTypes());
        request.setAttribute("from", from);
        request.setAttribute("to", to);

        return "/jsp/orderForm.jsp";
    }
}
