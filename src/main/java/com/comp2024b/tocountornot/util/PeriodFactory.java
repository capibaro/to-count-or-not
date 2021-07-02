package com.comp2024b.tocountornot.util;

import com.comp2024b.tocountornot.exception.BadRequestException;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Calendar;

public class PeriodFactory {
    public static Period getPeriod(int year, int month) {
        validate(year, month);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        Period period = new Period();
        period.setStart(new Timestamp(calendar.getTimeInMillis()));
        calendar.add(Calendar.MONTH, 1);
        period.setEnd(new Timestamp(calendar.getTimeInMillis()));
        return period;
    }

    public static Period getPeriod(int year, int month, int day) {
        validate(year, month, day);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Period period = new Period();
        period.setStart(new Timestamp(calendar.getTimeInMillis()));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        period.setEnd(new Timestamp(calendar.getTimeInMillis()));
        return period;
    }

    public static void validate(int year, int month) {
        try {
            LocalDateTime time = LocalDateTime.of(year,month,1,0,0);
        } catch (DateTimeException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public static void validate(int year, int month, int day) {
        try {
            LocalDateTime time = LocalDateTime.of(year,month,day,0,0);
        } catch (DateTimeException e) {
            throw  new BadRequestException(e.getMessage());
        }
    }
}
