# Java 11  Feature
## 1.List.copy
The List.copyOf method was introduced, providing a convenient way to create an immutable copy of a list. Here's an example of how to use it:

```java
import java.util.Arrays;
import java.util.List;

/**
 * List.CopyOf method return an unmodifiable copy version of the given collection
 */
public class Collections {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        List<Integer> copyList=List.copyOf(list);

        copyList.add(6);//this will throw an unsupportedOperationException

    }
}

```

## 2.HttpClient
The HttpClient class was introduced as part of the java.net.http package. This class provides a modern, flexible, and asynchronous API for making HTTP requests and handling responses. It's a replacement for the older HttpURLConnection API.

```java

public class HttpClients {
    public static void main(String[] args) {
        // Create an instance of HttpClient
        HttpClient httpClient=HttpClient.newHttpClient();

        // Build a GET request for the specified URI
        HttpRequest request = HttpRequest.newBuilder(
                URI.create("https://openlibrary.org/books/OL1M/lists.json")
        ).GET().build();

        // Send a synchronous GET request and get the response
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        // Send an asynchronous GET request and handle the response using CompletableFuture
        CompletableFuture<HttpResponse<String>> completableFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Handle the asynchronous response when it completes
        completableFuture.thenAccept(res-> System.out.println(res.body()));

        // Wait for the asynchronous operation to complete
         completableFuture.get();

    }
}

```

## 4.New File Methods 
We can use the new readString and writeString static methods from the Files class

```java
public class NewFileMethods {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("src/Java11/file.txt");
        Files.writeString(path,"writing");

        System.out.println(Files.readString(path));

        System.out.println(Files.isSameFile(path,path));

    }
}
```

### 5.String methods

```java
/**
 * isBlank(): This is a boolean method. It just returns true when a string is empty and vice-versa.
 *lines(): This method is to return a collection of strings that are divided by line terminators.
 *repeat(n): Result is the concatenated string of original string repeated the number of times in the argument.
 * stripLeading(): It is used to remove the white space which is in front of the string
 * stripTrailing(): It is used to remove the white space which is in the back of the string
 * strip(): It is used to remove the white spaces which are in front and back of the string
 */
public class NewStringMethods {
    public static void main(String[] args) {

       String str1 = "";
        System.out.println(str1.isBlank());

        String str2 = " xyz abc gh ";
        System.out.println(str2.isBlank());

        String str3="collection\nof\nStrings";
        System.out.println(str3.lines().toList());

        System.out.println(str2.repeat(3));

        System.out.println(str2.stripLeading());

        System.out.println(str2.stripTrailing());

        System.out.println(str2.strip());
    }
}
```

### output
```
true
false
[collection, of, Strings]
 xyz abc gh  xyz abc gh  xyz abc gh 
xyz abc gh 
 xyz abc gh
xyz abc gh
```

## 6.private methods in interfaces

In Java 11, a new feature called "private methods in interfaces" was introduced. This feature allows you to include private methods within an interface to encapsulate common code shared among multiple default or static methods. This helps improve code organization and promotes code reuse within interfaces without exposing the private methods to external classes.

```java
package Java11;

public class PrivateMethodsInInterfaces {


    public static void main(String[] args) {
        A a=new A();
        a.bar();

    }
}

interface inter {

    default void bar() {
        System.out.print("Hello");
        baz();

    }

    private void baz() {
        System.out.println(" world!");
    }
}

  class A implements inter{


}

```

## 7.Collectors To UnmodifiableList

```java
/**
 * Collectors.toUnmodifiableList()->return an unmodifiable  list
 *   Predicated.not method  it use to negate existing Predicated
 */
public class Streams {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());

        collect.add( 8);//this will throw an unsupportedOperationException


        List<Integer> oddNumber = list.stream()
                .filter(Predicate.not(i -> i % 2 == 0)).toList();
        System.out.println(oddNumber);

    }
}
```

## 8.Time Unit Conversion 

```java

/**
 * This method is used to convert the given time to a unit like DAY, MONTH, YEAR, and for time too.
 */
public class TimeUnitConversion {
    public static void main(String[] args) {
        TimeUnit c=TimeUnit.DAYS;
        System.out.println(c);

        System.out.println(c.convert(Duration.ofHours(24)));

        System.out.println(c.convert(Duration.ofHours(84)));
    }
}
```

## 9.List to Array conversion 
```java
/**
 * list.toArray method -> convert list to array
 */
public class ToArray {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("Java","Python","Go");

        String[] array=list.toArray(String[]::new);
    }
}
```

## 10.Try With Resource

The try-with-resources statement is a try statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement. Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.

```java
/**
 * auto-closed, a resource has to be both declared and initialized inside the try
 */
public class TryWithResource {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream =new FileOutputStream("src/Java11/file.txt")) {
            String msg = "TryWithResource";
            byte[] byteArray = msg.getBytes();
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfully!");
        }
      catch(Exception exception){
            System.out.println(exception.toString());
        }
    }
}

```

## 11.LocalVariableTypeInference

The var reserved type name (not a Java keyword) was introduced in Java 10. Type inference is used in var keyword in which it detects automatically the datatype of a variable based on the surrounding context.

```java
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
```






