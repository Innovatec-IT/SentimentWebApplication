package com.innovatec.SentimentWebApplication;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseServlet", value = "/response-servlet")
public class ResponseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String responseUser = request.getParameter("correct");
        System.out.println("korrekt svar? " + responseUser);

        response.setContentType("text/html");
        RequestDispatcher rd=request.getRequestDispatcher("/response.html");

        rd.forward(request, response);
    }
}
