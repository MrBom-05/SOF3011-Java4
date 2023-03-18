package com.example.controllers.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({"/login", "/login/store", "/sign-up", "/sign-up/store"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("sign-up")) {
            request.getRequestDispatcher("/views/user/sign-up.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("sign-up/store")) {
            signUpStore(request, response);
        } else if (uri.contains("login/store")) {
            loginStore(request, response);
        }
    }

    private void loginStore(HttpServletRequest request, HttpServletResponse response) {

    }

    private void signUpStore(HttpServletRequest request, HttpServletResponse response) {

    }
}
