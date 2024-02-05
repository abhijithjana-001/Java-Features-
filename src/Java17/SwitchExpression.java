package Java17;

/**
 *  "case L ->" labels that eliminate the need for break statements to prevent fall through. You can use a yield statement to specify the value of a switch expression.
 */

public class SwitchExpression {
    public static void main(String[] args) {
        // Enum representing days of the week
        enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY; }

        int numLetters = 0;
        Day day = Day.WEDNESDAY;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY                -> numLetters = 7;
            case THURSDAY, SATURDAY     -> numLetters = 8;
            case WEDNESDAY              -> numLetters = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);


       numLetters = switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                yield 6;
            case TUESDAY:
                yield 7;
            case THURSDAY:
            case SATURDAY:
                yield 8;
            case WEDNESDAY:
                yield 9;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);
    }
}
