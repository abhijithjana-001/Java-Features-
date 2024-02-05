package Java21;

/**
 * Enhance the Java language with unnamed patterns, which match a record component without stating the component's name or type, and unnamed variables, which can be initialized but not used. Both are denoted by an underscore character, _.
 */
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
