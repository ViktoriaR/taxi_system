package com.taxi_system.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 24.01.2018.
 */
public class ChangeLocaleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("locale");
        request.getSession().setAttribute("locale", locale);
        String page = request.getParameter("page");
        return page;
    }
}
