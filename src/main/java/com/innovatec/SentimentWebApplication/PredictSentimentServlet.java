package com.innovatec.SentimentWebApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "predictServlet", value = "/predict-servlet")
public class PredictSentimentServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Prediker sentiment i tekst.";
    }
    public PredictSentimentServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String encoding = request.getCharacterEncoding();
        System.out.println("encoding from page: " + encoding);
        // read form fields
        String text = request.getParameter("text");
        String category = request.getParameter("cat");

        testPythonOutput output = new testPythonOutput();

        output.userInput = text;
        output.category = category;

        // send the text for sentiment analyses
        output.readPythonScript();
        String prediction = output.ret;

        // set response type and get response writer
        response.setContentType("text/html");
        RequestDispatcher rd=request.getRequestDispatcher("/response.jsp");

        // Fix encoding for text
        System.out.println("userInput : " + text);

        byte[] bytes = text.getBytes();
        String ISO8859String = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("UTF-8 : " + ISO8859String);

        //set attributes for jsp file
        request.setAttribute("teksten", ISO8859String);
        request.setAttribute("kategorien", category);
        request.setAttribute("predikeringen", prediction);

        rd.forward(request, response);
    }

}