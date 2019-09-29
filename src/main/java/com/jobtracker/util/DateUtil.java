package com.jobtracker.util;

import com.jobtracker.entity.JobTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtil {

    private static final String DATE_FORMAT_STRING = "yyyy-MM-dd";

    public static List<Date> getListOfFirstMondaysFromListOfJobTimes(List<JobTime> jobTimeList) {
        return jobTimeList.stream()
            .map(jt -> DateUtil.getFirstDayOfMondayWeekFromDate(jt.getTimeIn()))
            .distinct()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }

    public static List<JobTime> getJobTimesWithinMondayWeek(List<JobTime> jobTimes, String firstDayOfWeek) {
        return jobTimes.stream()
            .filter(jt -> isWithinMondayWeekOf(parseDateString(firstDayOfWeek), jt.getTimeIn()))
            .collect(Collectors.toList());
    }

    private static Date getFirstDayOfMondayWeekFromDate(Date date) {
        Calendar calendar = getCalendarFromDate(date);
        setFirstDayOfCalendarWeekToMonday(calendar);
        resetCalendarTime(calendar);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        return getDateFromCalendar(calendar);
    }

    private static Date parseDateString(String dateString) {
        Date newDate = null;
        try {
            newDate = getDefaultSimpleDateFormat().parse(dateString);
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return newDate;
    }

    private static boolean isWithinMondayWeekOf(Date startingMondayDate, Date dateToTest) {
        Calendar startingMondayCalendar = getCalendarFromDate(startingMondayDate);
        if (!isMonday(startingMondayCalendar)) {
            throw new RuntimeException("startingMondayDate is not a monday");
        }
        Calendar sundayBeforeStartingMondayCalendar = getCalendarFromDate(startingMondayDate);
        sundayBeforeStartingMondayCalendar.add(Calendar.DATE, -1);
        Calendar endingMondayCalendar = getCalendarSevenDaysAheadOf(startingMondayCalendar);

        return (sundayBeforeStartingMondayCalendar.before(getCalendarFromDate(dateToTest))
             && endingMondayCalendar.after(getCalendarFromDate(dateToTest)));
    }

    private static Calendar getCalendarSevenDaysAheadOf(Calendar calendar) {
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(calendar.getTime());
        newCalendar.add(Calendar.DATE, 7);
        return newCalendar;
    }

    private static Calendar getCalendarFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private static Date getDateFromCalendar(Calendar calendar) {
        return calendar.getTime();
    }

    private static void setFirstDayOfCalendarWeekToMonday(Calendar calendar) {
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
    }

    private static void resetCalendarTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }

    private static boolean isMonday(Calendar calendar) {
        return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY);
    }

    private static SimpleDateFormat getDefaultSimpleDateFormat() {
        return new SimpleDateFormat(DATE_FORMAT_STRING);
    }
}
