# Java21 Features

## 1.String Template
String templates complement Java's existing string literals and text blocks by coupling literal text with embedded expressions and template processors to produce specialized results.
```java
/**
 * String Templates containing embedded expressions(evaluate at runtime )
 * now string contain variable ,method or fields commuted  at runtime
 */

public class StringTemplate {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        System.out.println(STR."sum of a and b is \{a+b}");
    }
}
```
### output
```
sum of a and b is 30
```
## 2.Sequenced Collections 
Introduce new interfaces to represent collections with a defined encounter order. Each such collection has a well-defined first element, second element, and so forth, up to the last element. It also provides uniform APIs for accessing its first and last elements, and for processing its elements in reverse order.
```java
public class SequencedCollections {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);


        System.out.println(list.getFirst());
        System.out.println(list.getLast());

//
       list.removeFirst();
//        System.out.println(list);
//     list.removeLast();
//        System.out.println(list);

        List<Integer> reversed = list.reversed();
        System.out.println(reversed);
        
    }
}

```
### output
```
1
7
[7, 6, 5, 4, 3, 2, 1]
```

## 3.Unnamed Class
Evolve the Java language so that students can write their first programs without needing to understand language features designed for large programs. Far from using a separate dialect of Java, students can write streamlined declarations for single-class programs and then seamlessly expand their programs to use more advanced features as their skills grow.

```java
void main(){
    System.out.println("Hello world");
}
```

### output
```
Hello world

Process finished with exit code 0
```

## 4.Unnamed Variables
Enhance the Java language with unnamed patterns, which match a record component without stating the component's name or type, and unnamed variables, which can be initialized but not used. Both are denoted by an underscore character, _. 

```java
public class UnnamedVariables {
    public static void main(String[] args) {

      try{

          var d=100/0;
      }
      catch (Exception _){
          System.out.println("ERROR");
      }
    }
}
```

## 5.Record Pattern 
Enhance the Java programming language with record patterns to deconstruct record values. Record patterns and type patterns can be nested to enable a powerful, declarative, and composable form of data navigation and processing.

```java
record  Point(int x,int y){}

public class RecordPattern {
    public static void main(String[] args) {
        Point obj=new Point(10,20);
        sum(obj);

    }

    public static void sum(Object obj){
        if(obj instanceof Point(int x,int y)){
            System.out.println(x+y);
        }
    }
}
```