package Java8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A function which takes in two arguments and produces a result.
 * Hence, this functional interface which takes in 3 parameters namely:-
 * T: denotes the type of the first argument to the function
 * U: denotes the type of the second argument to the function
 * R: denotes the return type of the function
 */
public class BiFunctionInterface {
    public static void main(String[] args) {

        System.out.println("apply()");
//         apply()

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // Implement add using apply()
        System.out.println("Sum = " + add.apply(2, 3));

        // BiFunction to multiply 2 numbers
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        // Implement add using apply()
        System.out.println("Product = " + multiply.apply(2, 3));

//        andThen()
        System.out.println(" andThen()");
        BiFunction <Integer, Integer, Integer> bfobj = (a, b) -> a * b;
//performs division
        Function<Integer, Integer> fobj = (c) -> c / 2;
//composed function
        System.out.println("The result is: " + bfobj.andThen(fobj).apply(70, 10));

    }
}
