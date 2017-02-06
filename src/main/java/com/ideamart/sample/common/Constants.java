package com.ideamart.sample.common;

/**
 * Created by Ehelepola on 20/01/2016.
 */
public final class Constants {

    public static final class ApplicationConstants {
        public static final String USSD_OP_MO_INIT = "mo-init";
        public static final String USSD_OP_MT_CONT = "mt-cont";
        public static final String USSD_OP_MT_FIN = "mt-fin";

        //local app apis
        public static final String USSD_URL = "http://127.0.0.1:7000/ussd/send";
        public static final String SMS_URL = "http://127.0.0.1:7000/sms/send";
        public static final String SUBSCRIPTION_MESSAGE_URL = "http://127.0.0.1:7000/subscription/send";
        public static final String SUBSCRIPTION_BASESIZE_URL = "http://127.0.0.1:7000/subscription/query-base";
        public static final String SUBSCRIPTION_STATUS_URL = "http://127.0.0.1:7000/subscription/getStatus";

        //IdeaMart APIs public
//        public static final String USSD_URL = "https://api.dialog.lk/ussd/send";
//        public static final String SMS_URL = "https://api.dialog.lk/sms/send";
//        public static final String SUBSCRIPTION_MESSAGE_URL = "https://api.dialog.lk/subscription/send";
//        public static final String SUBSCRIPTION_BASESIZE_URL = "https://api.dialog.lk/subscription/query-base";
//        public static final String SUBSCRIPTION_STATUS_URL = "https://api.dialog.lk/subscription/getStatus";

        // For registration action should be 1 (0 - Opt Out | 1 - Opt In)
        public static final String REG_ACTION = "1";

        //Specific Version
        public static final String VERSION = "1.0";

        //local app credentials
        public static final String PASSWORD = "password";
        public static final String APP_ID = "APP_00001";

        //hosted app credentials
//        public static final String PASSWORD = "";
//        public static final String APP_ID = "";

        //local database
        public static final String JDBC_URL = "jdbc:mysql://localhost:3306/Sajith";
        public static final String DATABASE_USERNAME = "root";
        public static final String DATABASE_PASSWORD = "";

        //hosted database credentials
//        public static final String JDBC_URL = "jdbc:mysql://localhost:3306/gknow";
//        public static final String DATABASE_USERNAME = "";
//        public static final String DATABASE_PASSWORD = "";

        public static final String DATABASE_TRAFFIC_TABLE_NAME = "qa";
//        public static final String DATABASE_USER_TABLE_NAME = "eechat_usernames";
        public static final String DATABASE_QUESTION_TABLE_NAME = "question";
        public static final String DATABASE_ANSWER_TABLE_NAME = "answer";
        public static final String DATABASE_DASHBOARD_TABLE_NAME = "qa_dashboard";


    }

    public static final class MessageConstants {
        public static final String HELP_SMS = "welcome to eechat ussd application.\n" +
                "            obata awashya thorathuru pahatha dakwei.\n" +
                " \n" +
                "            1.Usename ekak thoraganimata:-\n" +
                "            eechat <Space> UN <Space> Your name \n" +
                "            Sent To 77100.\n" +
                "\n" +
                "            2.Chat Kirimata:-eechat <Space> chat <Space> Friends Username <Space> Your message \n" +
                "            sent to 77100\n" +
                "              Ex:- \"eechat chat udaya hello mchn khomada.. -- sent to 77100\n";

        public static final String SMS_ANSWER_GUID = "Enter your answer as follows.\n <appname> <space> ans <space> <your number>" +
                "- 77100\n ex - dm ans 4";
        public static final String CORRECT_ANSWER_RESPONSE = "Your answer is correct. Thanks for the submission.";
        public static final String WRONG_ANSWER_RESPONSE = "Your answer is incorrect. Please try again.";
        public static final String MESSAGE_RESPONSE = "Thanks for your message. We'll reply you soon";
    }
}
