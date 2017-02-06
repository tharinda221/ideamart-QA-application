package com.ideamart.sample.restservices;

import com.ideamart.sample.sms.operations.Operations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tharinda on 2/7/17.
 */
public class sendSms extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        String message = request.getParameter("sms");
        Operations operations = new Operations();
        try {
            operations.sendSMSToUser(message, address);
            request.setAttribute("smsStatus", "Your sms has been sent to the user");
            RequestDispatcher rd=request.getRequestDispatcher("sendSms.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sendSms.jsp").forward(request,response);
    }
}
