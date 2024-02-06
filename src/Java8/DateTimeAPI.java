package Java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Scanner;

public class DateTimeAPI {

    public static void main(String[] args) {
//        localDateAndTime();
//       zone();
//       temporalAdjusters();
//        chronicUnits();
        PeriodAndDuration();
    }

    /**
     * Specialized date-time API to deal with various timezones.
     */
    public static void localDateAndTime(){
        LocalDate localDate=LocalDate.now();
        System.out.println(STR."the current date is \{localDate}");

        LocalTime localtime=LocalTime.now();
        System.out.println(STR."the current time is \{localtime}");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(STR."current date and time : \{localDateTime}");


        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = localDateTime.format(format);

        System.out.println(STR."in formatted manner \{formattedDateTime}");

        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int seconds = localDateTime.getSecond();
        System.out.println(STR."Month : \{month} day : \{day} seconds : \{seconds}");
    }

    /**
     * Zoned date-time API : Use it when time zones are to be considered
     */

    public static  void zone(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Scanner sc=new Scanner(System.in);
        //        Zones
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println(STR."the current zone is \{currentZone.getZone()}");

        List<String> list = ZoneId.getAvailableZoneIds().stream().sorted().toList();
        System.out.println(STR."Available Zones \n\{list}");

        System.out.println("Enter zoneId:");
        ZoneId zoneId=ZoneId.of(sc.nextLine());

        LocalDateTime  zonedDateTime=LocalDateTime.ofInstant(Instant.now(), zoneId);
        System.out.println(STR."Date and Time in \{zoneId}: \{zonedDateTime.format(format)}");
    }

    /**
     * TemporalAdjuster : It is used to perform various date related operations.
     */

    public static void temporalAdjusters(){
        LocalDate date = LocalDate.now();
        // get the next saturday
        LocalDate nextSaturday = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(STR."next saturday from now is \{nextSaturday}");

        // last day of current month
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(STR."lastDayOfMonth : \{lastDay}");

    }

    /**
     *  the ChronoUnit enum is used to represent units of time, such as days, hours, minutes, seconds, etc.
     *  This enum provides constants for various units of time and enables you to perform date and time calculations in a fluent and precise manner.
     */

    public static void chronicUnits(){
        // Get today's date
        LocalDate today = LocalDate.now();
        LocalDate fiveDaysLater = today.plusDays(5);
        System.out.println(STR."Five days later: \{fiveDaysLater}");

        // Subtract 2 weeks from today's date
        LocalDate twoWeeksAgo = today.minusWeeks(2);
        System.out.println(STR."Two weeks ago: \{twoWeeksAgo}");

        long daysDifference = ChronoUnit.DAYS.between(twoWeeksAgo, fiveDaysLater);
        System.out.println(STR."Difference in days: \{daysDifference}");
    }

    /**
     * Period : It deals with date based amount of time.
     * Duration : It deals with time based amount of time.
     */

    public static void PeriodAndDuration(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time1 = LocalTime.now();


        LocalDate date1 = LocalDate.now();

        LocalDate date2 =
                LocalDate.of(2045, Month.DECEMBER, 12);
        Period gap = Period.between(date2, date1);
        System.out.println(STR."gap between dates is a period of \{gap}");

        Duration fiveHours = Duration.ofHours(5);
        // adding five hours to the current
        // time and storing it in time2
        LocalTime time2 = time1.plus(fiveHours);
        System.out.println(STR."after adding five hours of duration \{time2.format(format)}");
    }

}
