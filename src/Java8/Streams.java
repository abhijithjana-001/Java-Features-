package Java8;

import java.util.Arrays;
import java.util.List;

/**
 * the Stream API was introduced as a powerful and functional approach to process collections of data. Streams provide a concise and expressive way to perform operations on data, making code more readable and allowing for parallel processing.
 */

public class Streams {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(2,3,1,3,34,54,65,34);

        System.out.println("Even Number");
        nums.stream().filter(n->n%2==0).forEach(e-> System.out.print(e+" "));

        System.out.println("\nodd Number");
        nums.stream().filter(n->n%2!=0).forEach(e-> System.out.print(e+" "));

        System.out.println("\nSum");
        System.out.print(nums.stream().reduce(0, Integer::sum));


//   Parallel Stream
//        square
        System.out.println("\nSquare");
        nums.parallelStream().map(e->e*e).forEach(System.out::println);

    }
}
