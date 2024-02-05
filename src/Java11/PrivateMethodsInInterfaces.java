package Java11;

/**
 *  include private methods within an interface to encapsulate common code shared among multiple default or static methods.
 */

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
