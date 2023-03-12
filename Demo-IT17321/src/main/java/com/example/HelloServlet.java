package com.example;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({
        "/hello"
})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = "KynnPH27937";
        request.setAttribute("hoTen", name);
        request.getRequestDispatcher("/views/hello.jsp").forward(request, response);
    }

    public void destroy() {
    }
}