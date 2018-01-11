package com.taxi_system.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 09.01.2018.
 */
public class RegistrationFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login", "Login");
        request.setAttribute("name", "Name");
        return "/jsp/registrationForm.jsp";
    }
}
