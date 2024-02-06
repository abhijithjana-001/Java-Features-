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
public class localDateAndTime {
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

###   Zoned date-time API
```java
  /**
     * Zoned date-time API : Use it when time zones are to be considered
     */

    public static  void zone(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Scanner sc=new Scanner(System.in);
        //        Zones
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println(STR."the current zone is \{currentZone.getZone()}");

        List<String> list = ZoneId.getAvailableZoneIds().stream().sorted().toList();
        System.out.println(STR."Available Zones \n\{list}");

        System.out.println("Enter zoneId:");
        ZoneId zoneId=ZoneId.of(sc.nextLine());

        LocalDateTime  zonedDateTime=LocalDateTime.ofInstant(Instant.now(), zoneId);
        System.out.println(STR."Date and Time in \{zoneId}: \{zonedDateTime.format(format)}");
    }
```

### output
```
the current zone is Asia/Calcutta
Available Zones 
[Africa/Abidjan, Africa/Accra, Africa/Addis_Ababa, Africa/Algiers, Africa/Asmara, ...]
Enter zoneId:
GMT
Date and Time in GMT: 06-02-2024 10:11:26

```

### TemporalAdjusters
```java
 /**
     * TemporalAdjuster : It is used to perform various date related operations.
     */

    public static void temporalAdjusters(){
        LocalDate date = LocalDate.now();
        // get the next saturday
        LocalDate nextSaturday = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(STR."next saturday from now is \{nextSaturday}");

        // last day of current month
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(STR."lastDayOfMonth : \{lastDay}");

    }
```

### output
```
next saturday from now is 2024-02-10
lastDayOfMonth : 2024-02-29
```
### ChronicUnit

the ChronoUnit enum is used to represent units of time, such as days, hours, minutes, seconds, etc. This enum provides constants for various units of time and enables you to perform date and time calculations in a fluent and precise manner.

```java
  public static void chronicUnits(){
        // Get today's date
        LocalDate today = LocalDate.now();
        LocalDate fiveDaysLater = today.plusDays(5);
        System.out.println(STR."Five days later: \{fiveDaysLater}");

        // Subtract 2 weeks from today's date
        LocalDate twoWeeksAgo = today.minusWeeks(2);
        System.out.println(STR."Two weeks ago: \{twoWeeksAgo}");

        long daysDifference = ChronoUnit.DAYS.between(twoWeeksAgo, fiveDaysLater);
        System.out.println(STR."Difference in days: \{daysDifference}");
    }
```
### output
```
Five days later: 2024-02-11
Two weeks ago: 2024-01-23
Difference in days: 19
```

### PeriodAndDuration
```java
    /**
     * Period : It deals with date based amount of time.
     * Duration : It deals with time based amount of time.
     */

    public static void PeriodAndDuration(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time1 = LocalTime.now();


        LocalDate date1 = LocalDate.now();

        LocalDate date2 =
                LocalDate.of(2045, Month.DECEMBER, 12);
        Period gap = Period.between(date2, date1);
        System.out.println(STR."gap between dates is a period of \{gap}");

        Duration fiveHours = Duration.ofHours(5);
        // adding five hours to the current
        // time and storing it in time2
        LocalTime time2 = time1.plus(fiveHours);
        System.out.println(STR."after adding five hours of duration \{time2.format(format)}");
    }

```

### output
```
gap between dates is a period of P-21Y-10M-6D
after adding five hours of duration 20:45:46
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
## 8.Functional Interface
A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.

```java
// Java program to demonstrate lambda expressions to
// implement a user defined functional interface.

@FunctionalInterface

interface Square {
	int calculate(int x);
}

class Test {
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

```

### output
```
25
```
## 9.BiFunction Interface
The BiFunction Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java. It represents a function which takes in two arguments and produces a result. Hence, this functional interface which takes in 3 parameters namely:-
* T: denotes the type of the first argument to the function
* U: denotes the type of the second argument to the function
* R: denotes the return type of the function

The BiFunction interface consists of the following two functions:

### 1. apply()
This method applies the given function to the arguments.

Syntax:
```
R apply(T t, U u)
```
Parameters: This method takes two parameters:
* t– the first function argument
* u– the second function argument

Returns: This method returns the function result which is of type R. Below is the code to illustrate apply() method:

```java
// Java Program to demonstrate
// BiFunction's apply() method

import java.util.function.BiFunction;

public class Main {
	public static void main(String args[])
	{
		// BiFunction to add 2 numbers
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

		// Implement add using apply()
		System.out.println("Sum = " + add.apply(2, 3));

		// BiFunction to multiply 2 numbers
		BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

		// Implement add using apply()
		System.out.println("Product = " + multiply.apply(2, 3));
	}
}

```

### output
```
Sum = 5
Product = 6
```
### 2. addThen()
It returns a composed function. It means the method first applies this function and then applies the after function. If the assessment of either function throws an exception, it is relayed to the caller of the composed function.

syntax 
```
default <V> BiFunction<T,U,V> andThen(Function<? super R,? extends V> after)  
```
Type-Parameter:
* V: It represents the type of the output of the after() function, and of the composed function.
* after: It applies after this function.
  Returns:

It returns a composed function. It means the method first applies this function and then applies the after function.

```java
import java.util.function.BiFunction;  
import java.util.function.Function;  
public class BiFunctionAndThenExample  
{  
public static void main(String args[])   
{  
//performs multiplication       
BiFunction <Integer, Integer, Integer> bfobj = (a, b) -> a * b;  
//performs division  
Function <Integer, Integer> fobj = (c) -> c / 2;  
//composed function  
System.out.println("The result is: " + bfobj.andThen(fobj).apply(70, 10));  
}  
}  
```
### output
```
The result is: 350
```


## 10.StringJoiner
StringJoiner is a new class added in Java 8 under java.util package.

Simply put, it can be used for joining Strings making use of a delimiter, prefix, and suffix.

```java
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
```

### output
```
Red,Green,Blue
```




    