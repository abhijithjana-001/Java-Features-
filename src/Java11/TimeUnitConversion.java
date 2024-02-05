package Java11;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * This method is used to convert the given time to a unit like DAY, MONTH, YEAR, and for time too.
 */
public class TimeUnitConversion {
    public static void main(String[] args) {
        TimeUnit c=TimeUnit.DAYS;
        System.out.println(c);

        System.out.println(c.convert(Duration.ofHours(24)));

        System.out.println(c.convert(Duration.ofHours(84)));
    }
}
