package com.taxi_system.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Victoria on 27.01.2018.
 */
@WebFilter(
        urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "locale", value = "en_US", description = "Locale Param")}
)

public class LocaleFilter implements Filter {
    private String locale;

    public void init(FilterConfig fConfig) throws ServletException {
        locale = fConfig.getInitParameter("locale");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String localeSession = (String) session.getAttribute("locale");
        if (localeSession == null) {
            session.setAttribute("locale", locale);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        locale = null;
    }
}
