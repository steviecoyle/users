package com.scoyle.users.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

    private DateConversion() {}

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String formatDateToAppFormat() {
        return new SimpleDateFormat(DATE_PATTERN).format(new Date());
    }
}
