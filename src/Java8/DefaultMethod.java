package Java8;

/**
 * allow the interfaces to have methods with implementation without affecting the classes that implement the interface.
 */

public class DefaultMethod {
    public static void main(String[] args) {
       AndroidPhone phone=new AndroidPhone();
       phone.call();
       phone.message();
    }
}

interface Phone{
    void call();
    default void message(){
        System.out.println("Sending ");
    }
}

class AndroidPhone implements  Phone{
    @Override
    public void call() {
        System.out.println("Calling");
    }
}

