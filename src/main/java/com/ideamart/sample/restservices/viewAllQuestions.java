package com.ideamart.sample.restservices;

import com.ideamart.sample.questionMgt.Question;
import com.ideamart.sample.questionMgt.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tharinda on 2/7/17.
 */
public class viewAllQuestions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDAO questionDAO = new QuestionDAO();
        ArrayList<Question> questionArrayList = questionDAO.getAllQuestions();
        request.setAttribute("questionArrayList", questionArrayList);
        getServletConfig().getServletContext().getRequestDispatcher("/viewAllQuestions.jsp").forward(request,response);
    }
}
