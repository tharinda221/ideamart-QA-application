package com.ideamart.sample.restservices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tharinda on 2/6/17.
 */
public class Test {

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String now = dateFormat.format(dateobj);
        System.out.println(now);

        String then = "06/02/17 16:16:03";
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date startDate;
        try {
            startDate = df.parse(then);
            String newDateString = df.format(startDate);
            System.out.println(newDateString);
            System.out.println(now.compareTo(then));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
