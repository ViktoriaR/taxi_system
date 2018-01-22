package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.facade.OrderFacade;
import com.taxi_system.services.CarTypeService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

/**
 * Created by Victoria on 11.01.2018.
 */
public class GetPriceCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String fromAddress = request.getParameter("fromAddress");
        String toAddress = request.getParameter("toAddress");
        String carType = request.getParameter("carType");
        String clientLogin = (String) request.getSession().getAttribute("username");

        if (StringUtils.isBlank(fromAddress) || StringUtils.isBlank(toAddress) || fromAddress.equals("From?") || toAddress.equals("To?")) {
            request.setAttribute("failedMessage", "Enter from and to address");
            CarTypeService carTypeService = new CarTypeService();
            request.setAttribute("carTypes", carTypeService.getCarTypes());
            page = "/jsp/orderForm.jsp";
        } else {
            Orders order = (Orders) request.getSession().getAttribute("order");
            if (order == null) {
                order = new Orders(fromAddress, toAddress, carType);
                request.getSession().setAttribute("order", order);
            } else {
                order.setFromAddress(fromAddress);
                order.setToAddress(toAddress);
                order.setCarType(carType);
            }
            OrderFacade.addPriceToOrder(order, clientLogin);

            page = "/jsp/price.jsp";
        }

        return page;
    }
}

