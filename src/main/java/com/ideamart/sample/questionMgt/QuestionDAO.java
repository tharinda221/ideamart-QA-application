package com.ideamart.sample.questionMgt;

import com.ideamart.sample.common.Constants;
import com.ideamart.sample.database.DatabaseConnection;
import org.apache.http.cookie.SM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tharinda on 2/4/17.
 */
public class QuestionDAO {

    private String tableQuestionName = Constants.ApplicationConstants.DATABASE_QUESTION_TABLE_NAME;
    private String tableAnswerName = Constants.ApplicationConstants.DATABASE_ANSWER_TABLE_NAME;

    private Connection connection;
    private Statement stmt;

    public boolean RegisterQuestion(Question question) throws ClassNotFoundException {

        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String sql = "INSERT INTO " + tableQuestionName + " VALUES (" + 0 + "," + "\"" + question.getQuestion() + "\"" + "," + "\"" + question.getAns1() + "\"" +
                    "," + "\"" + question.getAns2() + "\"" + "," + "\"" + question.getAns3() + "\"" + "," + "\"" + question.getAns4() + "\"" + "," + "\""
                    + question.getCorrectAnswer() + "\"" + "," + "\"" + question.getTimestamp() + "\"" + ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public Question getQuestionByID(int index) throws ClassNotFoundException {
        ResultSet resultSet = null;
        Question question = new Question();
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "Select * from " + tableQuestionName + " where `index`= " + "\"" + index + "\"" + ";";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                question.setIndex(index);
                question.setQuestion(resultSet.getString("question"));
                question.setAns1(resultSet.getString("ans1"));
                question.setAns2(resultSet.getString("ans2"));
                question.setAns3(resultSet.getString("ans3"));
                question.setAns4(resultSet.getString("ans4"));
                question.setCorrectAnswer(resultSet.getString("correctAnswer"));
                question.setTimestamp(resultSet.getString("timestamp"));
                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return question;
    }

    public boolean RegisterAnswer(String address, int qId, String timestamp, int count) throws ClassNotFoundException {

        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String sql = "INSERT INTO " + tableAnswerName + " VALUES (" + "\"" + address + "\"" + "," + "\"" + qId + "\"" +
                    "," + "\"" + timestamp + "\"" + "," + "\"" + count + "\"" + ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public void updateAnswerCount(String address, int qId) {
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String sql = "UPDATE " + tableAnswerName + " SET COUNT = COUNT + 1" + " where address= " + "\"" + address + "\"" +
                    " AND questionId= " + "\"" + qId + "\"" + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public boolean AnswerAvailable(String address, int qId) {
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "Select * from " + tableAnswerName + " where address= " + "\"" + address + "\"" +
                    " AND questionId= " + "\"" + qId + "\"" + ";";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return false;
    }

    public int getLastQuestionIndex() {
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "SELECT MAX(`index`) as max from `question`";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt("max");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return 0;
    }

    public ArrayList<Question> getAllQuestions() {
        ResultSet resultSet = null;

        ArrayList<Question> questionArrayList = new ArrayList<Question>();
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "SELECT * FROM `question`;";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Question question = new Question();
                question.setIndex(resultSet.getInt("index"));
                question.setQuestion(resultSet.getString("question"));
                question.setAns1(resultSet.getString("ans1"));
                question.setAns2(resultSet.getString("ans2"));
                question.setAns3(resultSet.getString("ans3"));
                question.setAns4(resultSet.getString("ans4"));
                question.setCorrectAnswer(resultSet.getString("correctAnswer"));
                question.setTimestamp(resultSet.getString("timestamp"));
                questionArrayList.add(question);
            }
            return questionArrayList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return questionArrayList;
    }

    public ArrayList<Answers> getSubmissionByTime(int index) {
        ResultSet resultSet = null;

        ArrayList<Answers> answersArrayList = new ArrayList<Answers>();
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "SELECT * FROM `answer` WHERE `questionId` = " + index + " ORDER BY timestamp ASC";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Answers answers = new Answers();
                answers.setTimestamp(resultSet.getString("timestamp"));
                answers.setAddress(resultSet.getString("address"));
                answers.setCount(resultSet.getInt("count"));
                answers.setQuestionId(resultSet.getInt("questionId"));
                answersArrayList.add(answers);
            }
            return answersArrayList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return answersArrayList;
    }

    public ArrayList<Answers> getSubmissionByCount(int index) {
        ResultSet resultSet = null;
        ArrayList<Answers> answersArrayList = new ArrayList<Answers>();
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "SELECT * FROM `answer` WHERE `questionId` = " + index + " ORDER BY count DESC";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Answers answers = new Answers();
                answers.setTimestamp(resultSet.getString("timestamp"));
                answers.setAddress(resultSet.getString("address"));
                answers.setCount(resultSet.getInt("count"));
                answers.setQuestionId(resultSet.getInt("questionId"));
                answersArrayList.add(answers);
            }
            return answersArrayList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return answersArrayList;
    }

    public void registerSMS(SMS sms) {
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String sql = "INSERT INTO " + "sms" + " VALUES (" + "\"" + sms.getAddress() + "\"" + "," + "\""
                    + sms.getMesssage() + "\"" + "," + "\"" + sms.getResponse() + "\"" + ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public boolean smsAvailability(String address) {
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "Select * from " + "sms" + " where address= " + "\"" + address + "\"" + ";";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return false;
    }

    public void updateMessage(String address, String message) throws ClassNotFoundException, SQLException {
        connection = DatabaseConnection.getDBInstance().getConnection();
        stmt = connection.createStatement();
        String sql = "UPDATE " + "sms" + " SET message= " + "\"" + message + "\"" + " WHERE address= " + "\"" + address + "\"" + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        connection.close();
        connection = null;
    }

    public void updateResponse(String address, String response) throws ClassNotFoundException, SQLException {
        connection = DatabaseConnection.getDBInstance().getConnection();
        stmt = connection.createStatement();
        String sql = "UPDATE " + "sms" + " SET response= " + "\"" + response + "\"" + " WHERE address= " + "\"" + address + "\"" + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        connection.close();
        connection = null;
    }

    public ArrayList<SMS> getAllSMS() {
        ResultSet resultSet = null;

        ArrayList<SMS> smsArrayList = new ArrayList<SMS>();
        try {
            connection = DatabaseConnection.getDBInstance().getConnection();
            stmt = connection.createStatement();
            String query = "SELECT * FROM `sms`;";
            System.out.println(query);
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                SMS sms = new SMS();
                sms.setMesssage(resultSet.getString("message"));
                sms.setAddress(resultSet.getString("address"));
                sms.setResponse(resultSet.getString("response"));
                smsArrayList.add(sms);
            }
            return smsArrayList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return smsArrayList;
    }

}
