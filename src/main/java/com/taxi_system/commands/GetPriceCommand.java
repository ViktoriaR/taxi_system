package com.taxi_system.commands;

import com.taxi_system.db_entities.Orders;
import com.taxi_system.facade.OrderFacade;
import com.taxi_system.services.CarTypeService;
import com.taxi_system.variables.Variables;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 11.01.2018.
 */
public class GetPriceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

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
            logger.info("user " + clientLogin + " enter wrong data to order form");
        } else {
            Orders order = (Orders) request.getSession().getAttribute(Variables.ORDER_NAME.getValue());
            if (order == null) {
                order = new Orders(fromAddress, toAddress, carType);
                request.getSession().setAttribute(Variables.ORDER_NAME.getValue(), order);
                logger.info("user " + clientLogin + " create new order");
            } else {
                order.setFromAddress(fromAddress);
                order.setToAddress(toAddress);
                order.setCarType(carType);
                logger.info("user " + clientLogin + " update data in order");
            }
            OrderFacade.addPriceToOrder(order, clientLogin);
            logger.info("user " + clientLogin + " add price to order");

            page = Variables.PRICE_PAGE.getValue();
        }

        return page;
    }
}

