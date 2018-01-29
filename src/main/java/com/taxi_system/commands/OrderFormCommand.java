package com.taxi_system.commands;

import com.taxi_system.services.CarTypeService;
import com.taxi_system.variables.Variables;

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
        CarTypeService carTypeService = new CarTypeService();
        request.getSession().setAttribute(Variables.CAR_TYPES_NAME.getValue(), carTypeService.getCarTypes());

        return Variables.ORDER_FORM_PAGE.getValue();
    }
}
