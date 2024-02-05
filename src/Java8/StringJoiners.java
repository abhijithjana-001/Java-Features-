package Java8;

import java.util.StringJoiner;

/**
 * it can be used for joining Strings making use of a delimiter, prefix, and suffix.
 */
public class StringJoiners {
    public static void main(String[] args) {
        StringJoiner stringJoiner=new StringJoiner(",");
//        We can add Strings using the add() method:
        stringJoiner.add("Red")
                .add("Green")
                .add("Blue");


        System.out.println(stringJoiner);
    }
}
