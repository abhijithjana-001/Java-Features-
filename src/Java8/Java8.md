# Java 8  Feature

## 1.DefaultMethod 

In Java 8, default methods were introduced as a new feature to enhance the flexibility of interfaces. Before Java 8, interfaces could only declare method signatures, and any class implementing an interface had to provide implementations for all of its methods. However, with the introduction of default methods, interfaces can now provide a default implementation for a method.

```java
interface TestInterface 
{ 
    // abstract method 
    public void square(int a); 
  
    // default method 
    default void show() 
    { 
      System.out.println("Default Method Executed"); 
    } 
} 
  
class TestClass implements TestInterface 
{ 
    // implementation of square abstract method 
    public void square(int a) 
    { 
        System.out.println(a*a); 
    } 
  
    public static void main(String args[]) 
    { 
        TestClass d = new TestClass(); 
        d.square(4); 
  
        // default method executed 
        d.show(); 
    } 
} 
```
### Output
```
 16
 Default Method Executed
```

## 2.Date/Time Api
New date-time API is introduced in Java 8 to overcome the following drawbacks of old date-time API :

 1.Not thread safe : Unlike old java.util.Date which is not thread safe the new date-time API is immutable and doesn’t have setter methods.

 2.Less operations : In old API there are only few date operations but the new API provides us with many date operations.

allow the interfaces to have methods with implementation without affecting the classes that implement the interface.
```java
public class DateTimeAPI {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println(STR."the current date is \{localDate}");

        LocalTime localtime=LocalTime.now();
        System.out.println(STR."the current time is \{localtime}");

        LocalDateTime current = LocalDateTime.now();
        System.out.println(STR."current date and time : \{current}");
        
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = current.format(format);

        System.out.println(STR."in formatted manner \{formattedDateTime}");

        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println(STR."Month : \{month} day : \{day} seconds : \{seconds}");
    }
}

```
### output
```
the current date is 2024-02-05
the current time is 12:28:48.595881300
current date and time : 2024-02-05T12:28:48.595881300
in formatted manner 05-02-2024 12:28:48
Month : FEBRUARY day : 5 seconds : 48
```

## 3. ForEach
```java

public class ForEachExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using forEach with a lambda expression
        numbers.forEach(number -> System.out.println(number * 2));

        // Using forEach with a method reference
        numbers.forEach(System.out::println);
    }
}

```
In this example:

1.numbers is a list of integers.

2.The first forEach call uses a lambda expression to double each number and print the result.

3.The second forEach call uses a method reference to directly print each number.

4.When you run this program, you'll get output like:

### output
```
2
4
6
8
10
1
2
3
4
5

```

## 4.Lambda Expressions
Lambda Expression basically expresses an instance of the functional interface


```java
public class Lambda {
    @FunctionalInterface
    interface Multiplication
    {
        int multi(int x,int y);
    }

    public static void main(String[] args) {
            Multiplication multiplication=(x,y)->x*y;

            System.out.println(multiplication.multi(2,3));
    }
}
```
### output
```
6
```
## 5.Method Reference
Method reference is a shorthand notation of a lambda expression to call a method.

Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference


```java
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
```

## 6.Optional Class
Optional class is designed to address the issue of dealing with null values in a more expressive and less error-prone manner.

The primary motivation behind Optional is to encourage more explicit handling of the possibility of a value being absent, thus helping to avoid NullPointerExceptions. Instead of directly returning a nullable object, a method can return an Optional to indicate the potential absence of a value.

```java
import java.util.Optional;

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

```
### output
```
Optional.empty
3
```

## 7.Stream
The Stream API was introduced as part of the java.util.stream package. Streams provide a declarative and functional approach to process sequences of elements (e.g., collections) in a concise and expressive way. Streams enable parallel processing, making it easier to take advantage of multicore processors.

```java
import java.util.Arrays;
import java.util.List;

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
```
