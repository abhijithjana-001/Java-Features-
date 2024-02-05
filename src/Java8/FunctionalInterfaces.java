package Java8;

/**
 * A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods
 */


    @FunctionalInterface

    interface Square {
        int calculate(int x);
    }

public class FunctionalInterfaces  {
        public static void main(String args[])
        {
            int a = 5;

            // lambda expression to define the calculate method
            Square s = (int x) -> x * x;

            // parameter passed and return type must be
            // same as defined in the prototype
            int ans = s.calculate(a);
            System.out.println(ans);
        }
    }



