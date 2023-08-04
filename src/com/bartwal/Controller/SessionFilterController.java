package com.bartwal.Controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilterController implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(false);
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        String requestURI = httpServletRequest.getRequestURI();

        if (session != null || requestURI.equals("/")) {
//            if(httpServletRequest.getParameter("email") == session.getAttribute("email")){
//                session.invalidate();
//            }else{
                filterChain.doFilter(servletRequest, servletResponse);
//            }
        } else {
            httpServletResponse.sendRedirect("/views/ErrorPage.jsp");
        }

        System.err.println(" path = " + path);

/*
        if(session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            httpServletResponse.sendRedirect("/ErrorPage.jsp");
        }
*/

    }

    @Override
    public void destroy() {
        //for clean-up code
    }
}
