package Java8;

import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> values= Arrays.asList(1,2,3,4,5);
        values.forEach(System.out::println);
    }

}
