package com.taxi_system.commands;

import com.taxi_system.variables.Variables;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 29.01.2018.
 */
public class OrderDetailsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return Variables.DETAILS_PAGE.getValue();
    }
}
