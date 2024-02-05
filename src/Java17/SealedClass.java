package Java17;

/**
 * sealed class will give you more control on which classes may extend your class
 */

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


