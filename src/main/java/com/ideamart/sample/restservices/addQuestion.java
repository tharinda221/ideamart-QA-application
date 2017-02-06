package com.ideamart.sample.restservices;

import com.ideamart.sample.questionMgt.Question;
import com.ideamart.sample.questionMgt.QuestionDAO;
import com.ideamart.sample.sms.operations.Operations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tharinda on 2/6/17.
 */
public class addQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String now = dateFormat.format(dateobj);
        Question question = new Question();
        question.setQuestion(request.getParameter("question"));
        question.setAns1(request.getParameter("ans1"));
        question.setAns2(request.getParameter("ans2"));
        question.setAns3(request.getParameter("ans3"));
        question.setAns4(request.getParameter("ans4"));
        question.setCorrectAnswer(request.getParameter("correctAns"));
        question.setTimestamp(now);

        //adding to database
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            questionDAO.RegisterQuestion(question);
            Operations operations = new Operations();
            operations.sendQuestionToUsers(question);
            request.setAttribute("statusMessage", "your question has been sent to all users");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addQuestion.jsp").forward(request,response);
    }
}
