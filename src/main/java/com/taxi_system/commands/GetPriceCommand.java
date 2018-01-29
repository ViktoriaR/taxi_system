package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.facade.OrderFacade;
import com.taxi_system.services.CarTypeService;
import com.taxi_system.variables.Variables;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 11.01.2018.
 */
public class GetPriceCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String fromAddress = request.getParameter(Variables.FROM_ADDRESS_NAME.getValue());
        String toAddress = request.getParameter(Variables.TO_ADDRESS_NAME.getValue());
        String carType = request.getParameter(Variables.CAR_TYPE_NAME.getValue());
        String clientLogin = (String) request.getSession().getAttribute(Variables.USER_NAME.getValue());
        CarTypeService carTypeService = new CarTypeService();

        if (StringUtils.isBlank(fromAddress) || StringUtils.isBlank(toAddress) || StringUtils.isBlank(carType) || carTypeService.getCarTypeByName(carType) == null) {
            request.setAttribute(Variables.EXCEPTION_NAME.getValue(), Variables.PRICE_EXCEPTION_MESSAGE.getValue());
            page = Variables.ORDER_FORM_PAGE.getValue();
        } else {
            Orders order = (Orders) request.getSession().getAttribute(Variables.ORDER_NAME.getValue());
            if (order == null) {
                order = new Orders(fromAddress, toAddress, carType);
                request.getSession().setAttribute(Variables.ORDER_NAME.getValue(), order);
            } else {
                order.setFromAddress(fromAddress);
                order.setToAddress(toAddress);
                order.setCarType(carType);
            }
            OrderFacade.addPriceToOrder(order, clientLogin);

            page = Variables.PRICE_PAGE.getValue();
        }

        return page;
    }
}

