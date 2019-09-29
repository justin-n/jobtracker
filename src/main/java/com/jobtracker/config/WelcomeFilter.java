package com.jobtracker.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            filterChain.doFilter(request, response);
        }
        else {

            if (requestURIPointsToBaseURL((HttpServletRequest)request)) {

                redirectResponseToWelcomeFile((HttpServletResponse)response);
            }
            else {

                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() { }

    private boolean requestURIPointsToBaseURL(HttpServletRequest request) {

        return (request.getRequestURI().equals("/jobtracker/") || request.getRequestURI().equals("/jobtracker"));
    }

    private void redirectResponseToWelcomeFile(HttpServletResponse response) throws IOException {
        response.sendRedirect("/jobtracker/index.html");
    }
}
