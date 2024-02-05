# Java17 Features

## 1.Record 
Java Records provide a concise way to declare classes that are primarily used to store and transport data. They are an excellent fit for immutable data-centric classes, such as DTOs (Data Transfer Objects).
```java

/**
 * records will allow you to create immutable data classes
 */
 record Employee(Long id,double salary,int yearOfExperience ) {}

class  Records{
    public static void main(String[] args) {
        Employee emp=new Employee(1L,100000,10);

        System.out.println(emp);
        System.out.println(emp.id());
    }
}

```

## 2.SealedClass
Sealed classes provide a way to restrict which other classes or interfaces can extend or implement them. This is achieved by declaring a finite set of permitted subclasses or interfaces.

```java
sealed class A permits  B,C{
void print(){
    System.out.println("A");
}
}
final class  B extends A{
    void print(){
        super.print();
        System.out.println("B");
    }

}
non-sealed class C extends A{
    void print(){
        super.print();
        System.out.println("C");
    }

}

class D extends  C{
    void print(){
        super.print();
        System.out.println("D");
    }

}



public class SealedClass {
    public static void main(String[] args) {
       D d=new D();
       d.print();

    }
}

```

* The sealed class A permits only the subclasses B and C. This restricts the inheritance hierarchy.
* The print methods in each class are overridden to demonstrate method overriding in the inheritance chain.
* In the main method, an instance of class D is created, and its print method is called. The output will be a combination of "A," "C," and "D" due to the overridden methods in the inheritance chain.

## 3.Collectors.teeing
It is a new static method teeing to java.util.stream.Collectors interface which allows to collect using two independent collectors, then merge their results using the supplied BiFunction.

Every element passed to the resulting collector is processed by both downstream collectors, then their results are merged using the specified merge function into the final result.

```java
/**
 * collectors.teeing
 * collectors.toList
 */
public class Streams {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);
        Integer collect = list.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Integer::min),
                        Collectors.maxBy(Integer::max),
                        (min, max) -> min.get() + max.get()
                )
        );
        System.out.println(collect);

       List<Integer>integers= Stream.of(1,2,3,4,5).toList();
    }
}
```

## 4.String Method

### indent
The indent(int i) method, in the simplest usage, adds space characters at the start of every line,
with the argument indicating how many spaces to add. However, if that argument is a negative value,
the method will delete up to that many whitespace characters from the beginning of each line. In other
words, with the argument -2, zero, one, or two whitespace characters will be removed from each line

```java
public class StringMethod {
    public static void main(String[] args) {
        String text = "StringIndent";
//        if indent value is greater than 0 then it will add space beginning of string
        System.out.println(text.indent(4));
        String text2 = "  StringIndent";
        // if indent value is less than 0 then it will remove space beginning of string
        System.out.println(text.indent(-2));

        String t = "StringMethod";

        // Using the transform method to create a new StringBuilder and delete a range of characters
        // The lambda function takes a value (original string) and returns a transformed value (StringBuilder)
        StringBuilder transform = t.transform(value -> new StringBuilder(value).delete(6, 12));
        System.out.println(transform);


    }
}

```
### 1.indent method
* The indent method is used to adjust the indentation of a string.
* If the argument is positive, it adds the specified number of spaces at the beginning of the string.
* If the argument is negative, it removes the specified number of spaces from the beginning of the string.

### 2.Transform Method

* The transform method is part of the java.lang.String class, introduced in Java 16.
* It allows you to transform a String into another type by providing a Function<String, R> as an argument.
* In your example, you're using transform to create a StringBuilder and delete a range of characters from the original string.
* The lambda function takes the original string (value) and returns a transformed value (StringBuilder).

## 5.Switch Expression

### "case L ->" Labels

```java
public enum Day { SUNDAY, MONDAY, TUESDAY,
    WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }

// ...
class  A {
    public static void main() {
        int numLetters = 0;
        Day day = Day.WEDNESDAY;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY                -> numLetters = 7;
            case THURSDAY, SATURDAY     -> numLetters = 8;
            case WEDNESDAY              -> numLetters = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);
        System.out.println(numLetters);
    }
}
```

### "case L:" Statements and the yield Statement

```java
    int numLetters = switch (day) {
        case MONDAY, FRIDAY, SUNDAY -> {
            System.out.println(6);
            yield 6;
        }
        case TUESDAY -> {
            System.out.println(7);
            yield 7;
        }
        case THURSDAY, SATURDAY -> {
            System.out.println(8);
            yield 8;
        }
        case WEDNESDAY -> {
            System.out.println(9);
            yield 9;
        }
        default -> {
            throw new IllegalStateException("Invalid day: " + day);
        }
    };  
```


## 6.TextBlocks
They provide a more readable and convenient way to represent multiline strings in Java. A text block is a multi-line string literal that avoids the need for escape sequences and automatically formats the text in a readable way.

Text blocks start with a “”” (three double-quote marks) followed by optional whitespaces and a newline. The most simple example looks like this:

String example = """
Example text""";

the result type of text block is still a String. Text blocks just provide us with another way to write String literals in our source code.

```java
public class TextBlock {
    public static void main(String[] args) {
        String textBlock= """
                {
                "name":"Abhijith",
                "age":"22"
                }
                """;
        System.out.println(textBlock);
    }


}

```

Inside the text blocks, we can freely use newlines and quotes without the need for escaping line breaks. It allows us to include literal fragments of HTML, JSON, SQL, or whatever we need, in a more elegant and readable way.
