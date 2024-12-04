package com.scoyle.users.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateConversionTest {

    @Test
    void verify_correct_date_format() {
        assertEquals("yyyy-MM-dd HH:mm:ss", DateConversion.DATE_PATTERN);
    }

    @Test
    void verify_current_date_time() {
        String currentDateTime = DateConversion.formatDateToAppFormat();
        System.out.println(currentDateTime);
        try {
            parseEsDocDate(currentDateTime);
        } catch (Exception ex) {
            System.out.println();
        }
    }

    private Date parseEsDocDate(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern(DateConversion.DATE_PATTERN)).toDate();
    }
}
