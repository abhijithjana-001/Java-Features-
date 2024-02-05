package Java17;

/**
 * StringIndent
 * transform
 */
public class StringMethod {
    public static void main(String[] args) {
        String text="StringIndent";
//        if indent value is greater than 0 then it will add space beginning of string
        System.out.println(text.indent(4));
        String text2="  StringIndent";
        // if indent value is less than 0 then it will remove space beginning of string
        System.out.println(text.indent(-2));

        String t="StringMethod";

        // Using the transform method to create a new StringBuilder and delete a range of characters
        // The lambda function takes a value (original string) and returns a transformed value (StringBuilder)
        StringBuilder transform = t.transform(value -> new StringBuilder(value).delete(6, 12));
        System.out.println(transform);


    }
}
