package Java8;

/**
 *Lambda expressions basically express instances of functional interfaces (An interface with a single abstract method is called a functional interface
 */
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


