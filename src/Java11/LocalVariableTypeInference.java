package Java11;

import java.util.stream.IntStream;

/**
 *  The var keyword in Java is used for local variable type inference. It allows you to declare a variable without explicitly specifying its type, and the compiler infers the type based on the initializer. The var keyword can be used with lambda expressions as well.
 */
public class LocalVariableTypeInference {
    public static void main(String[] args) {
        // int
        var x = 100;

        // double
        var y = 1.90;

        // char
        var z = 'a';

        // string
        var p = "name";

        // boolean
        var q = false;

        // type inference is used in var keyword in which it
        // automatically detects the datatype of a variable
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(p);
        System.out.println(q);
    }
}
