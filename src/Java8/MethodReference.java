package Java8;

import java.util.Arrays;
import java.util.List;

/**
 * Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference
 */

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> num= Arrays.asList(1,2,3,4,5);
//        with lambda
        num.forEach(i-> System.out.println(i));
//        MethodReference
        num.forEach(System.out::println);
//        with lambda
        num.forEach(i->printNumber(i));
//        with MethodReference
        num.forEach(MethodReference::printNumber);
    }
    public static void printNumber(Integer number) {
        System.out.println(number*2);
    }
}
