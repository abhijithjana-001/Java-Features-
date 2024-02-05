package Java21;

/**
 * Enhance the Java programming language with record patterns to deconstruct record values. Record patterns and type patterns can be nested to enable a powerful, declarative, and composable form of data navigation and processing
 */
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
