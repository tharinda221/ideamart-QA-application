package com.ideamart.sample.restservices;

import com.ideamart.sample.questionMgt.Answers;
import com.ideamart.sample.questionMgt.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tharinda on 2/6/17.
 */
public class viewSubmissions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getParameter("type");
        QuestionDAO questionDAO = new QuestionDAO();
        ArrayList<Answers> answersArrayList;
        int index = Integer.parseInt(request.getParameter("question"));
        if (opt.equals("time")) {
            answersArrayList = questionDAO.getSubmissionByTime(index);
            request.setAttribute("resultList", answersArrayList);
            getServletConfig().getServletContext().getRequestDispatcher("/viewSubmissions.jsp").forward(request,response);
        } else {
            answersArrayList = questionDAO.getSubmissionByCount(index);
            request.setAttribute("resultList", answersArrayList);
            getServletConfig().getServletContext().getRequestDispatcher("/viewSubmissions.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("viewSubmissions.jsp").forward(request,response);
    }
}
