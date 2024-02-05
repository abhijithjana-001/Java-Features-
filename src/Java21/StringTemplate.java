package Java21;

/**
 * String Templates containing embedded expressions(evaluate at runtime )
 * now string contain variable ,method or fields commuted  at runtime
 */

public class StringTemplate {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        System.out.println(STR."sum of a and b is \{a+b}");
    }
}
