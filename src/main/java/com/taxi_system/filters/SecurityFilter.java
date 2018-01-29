package com.taxi_system.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Victoria on 27.01.2018.
 */

@WebFilter(
        urlPatterns = {"*.jsp"}
)

public class SecurityFilter implements Filter {

    public void init(FilterConfig fConfig)throws ServletException{
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.sendRedirect(req.getContextPath());
        return;
    }

    public void destroy() {
    }
}