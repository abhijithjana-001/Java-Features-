package Java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println("the current date is "+localDate);

        LocalTime localtime=LocalTime.now();
        System.out.println("the current time is "+localtime);

        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : "+
                current);


        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = current.format(format);

        System.out.println("in formatted manner "+
                formattedDateTime);

        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : "+month+" day : "+
                day+" seconds : "+seconds);




    }
}
