package Java11;
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
