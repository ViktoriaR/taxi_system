package com.taxi_system.servlet;

import com.taxi_system.commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Victoria on 02.01.2018.
 */

public class TaxiSystemServletHelper {

    private static TaxiSystemServletHelper instance = null;
    HashMap<String, Command> commands = new HashMap<String, Command>();

    public TaxiSystemServletHelper() {
        commands.put("loginForm", new LoginFormCommand());
        commands.put("registrationForm", new RegistrationFormCommand());
        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("orderForm", new OrderFormCommand());
        commands.put("getPrice", new GetPriceCommand());
        commands.put("processOrder", new ProcessOrderCommand());
        commands.put("changeLocale", new ChangeLocaleCommand());
        commands.put("orderDetails", new OrderDetailsCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        Command command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new MissingCommand();
        }
        return command;
    }

    public static TaxiSystemServletHelper getInstance() {
        if (instance == null) {
            instance = new TaxiSystemServletHelper();
        }
        return instance;
    }
}

