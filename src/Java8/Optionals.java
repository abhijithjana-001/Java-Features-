package Java8;

import java.util.Optional;

/**
 * the Optional class was introduced as part of the java.util package. The primary purpose of Optional is to provide a container for an optional value, indicating whether a value is present or absent. It helps to eliminate the use of null and handle potentially null values more effectively.
 */

public class Optionals {
    public static void main(String[] args) {
//        array of size 5
        Integer [] a={1,2,3,4,5};

        Optional<Integer> empty = Optional.empty();

        System.out.println(empty);

        Optional<Integer> value = Optional.of(a[2]);

        System.out.println(value.get());




    }
}


