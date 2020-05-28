package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            String[] arr = str.split(" ");
            int year = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int week = Integer.parseInt(arr[2]);
            int day = Integer.parseInt(arr[3]);
            System.out.println(outDay(year, month, week, day));
        }
        input.close();
    }

    private static String outDay(int year, int month, int week, int day) {
        Date date = new Date(year - 1900, month - 1, 1);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            calendar.setTime(date);
            int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (1 == dayWeek) {
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }
            calendar.add(Calendar.DAY_OF_WEEK, (week - 1) * 7);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            System.out.println(calendar.getTime());
            calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - dayWeek - 1 + day);
            return simpleDateFormat.format(calendar.getTime());
        } catch (Exception ex) {
            return "0";
        }
    }
}
