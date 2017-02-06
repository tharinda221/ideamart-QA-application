/*
 *Copyright 2015 Tharinda Dilshan Ehelepola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ideamart.sample.sms.operations;

import com.ideamart.sample.questionMgt.Answers;
import com.ideamart.sample.questionMgt.Question;
import com.ideamart.sample.questionMgt.QuestionDAO;
import com.ideamart.sample.questionMgt.SMS;
import com.ideamart.sample.sms.send.SendMessage;
import com.ideamart.sample.usermgt.User;
import com.ideamart.sample.usermgt.UserDAO;
import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.sms.messages.MoSmsReq;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ideamart.sample.common.Constants;

/**
 * This class is created for do operations for messages.
 */
public class Operations {

    public void sendQuestionToUsers(Question question) {
        String msg = question.getQuestion() + "\n" + "1. " + question.getAns1() + "\n" +
                "2. " + question.getAns2() + "\n" + "3. " + question.getAns3() + "\n" + "4. " + question.getAns4() + "\n" +
                Constants.MessageConstants.SMS_ANSWER_GUID;
        SendMessage sendMessage = new SendMessage();
        sendMessage.SendMessage(msg, Constants.ApplicationConstants.APP_ID,
                "tel:all", Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);
    }

    public void chat(String message, String address) throws SQLException, ClassNotFoundException {
        QuestionDAO questionDAO = new QuestionDAO();
        if(questionDAO.smsAvailability(address)) {
            questionDAO.updateResponse(address, message);
        } else {
            SMS sms = new SMS();
            sms.setAddress(address);
            sms.setResponse(message);
            sms.setMesssage("");
            questionDAO.registerSMS(sms);
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.SendMessage(Constants.MessageConstants.MESSAGE_RESPONSE, Constants.ApplicationConstants.APP_ID,
                address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);

    }

    public void getAnswer(String answer, String address) {
        QuestionDAO questionDAO = new QuestionDAO();
        Question question;

        try {
            int lastIndex = questionDAO.getLastQuestionIndex();
            question = questionDAO.getQuestionByID(lastIndex);
            String correctAnswer = question.getCorrectAnswer();
            if(correctAnswer.equals(answer)) {
                if(!questionDAO.AnswerAvailable(address, lastIndex)) {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                    Date dateobj = new Date();
                    String now = dateFormat.format(dateobj);
                    questionDAO.RegisterAnswer(address, lastIndex, now, 0);
                } else {
                    questionDAO.updateAnswerCount(address, lastIndex);
                }
                SendMessage sendMessage = new SendMessage();
                sendMessage.SendMessage(Constants.MessageConstants.CORRECT_ANSWER_RESPONSE, Constants.ApplicationConstants.APP_ID,
                        address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);

            } else {
                SendMessage sendMessage = new SendMessage();
                sendMessage.SendMessage(Constants.MessageConstants.WRONG_ANSWER_RESPONSE, Constants.ApplicationConstants.APP_ID,
                        address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendSMSToUser(String sms, String address) throws SQLException, ClassNotFoundException {
        QuestionDAO questionDAO = new QuestionDAO();
        if(questionDAO.smsAvailability(address)) {
            questionDAO.updateMessage(address, sms);
            SendMessage sendMessage = new SendMessage();
            sendMessage.SendMessage(sms, Constants.ApplicationConstants.APP_ID,
                    address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);
        } else {
            SMS smsObj = new SMS();
            smsObj.setAddress(address);
            smsObj.setMesssage(sms);
            smsObj.setResponse("");
            questionDAO.registerSMS(smsObj);
            SendMessage sendMessage = new SendMessage();
            sendMessage.SendMessage(sms, Constants.ApplicationConstants.APP_ID,
                    address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);
        }
    }

    public void sendErrorMessage(String address) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.SendMessage("Oba kala yomu kireema waradiya", Constants.ApplicationConstants.APP_ID,
                address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);
    }
}
