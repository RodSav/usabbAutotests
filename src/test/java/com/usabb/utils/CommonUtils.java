package com.usabb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
