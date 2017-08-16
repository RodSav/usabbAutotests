package com.virco.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${Timonov_Viacheslav} on 5/25/17.
 */
public class CommonUtils {

    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
