package Java17;

/**
 * textBlock
 * They provide a more readable and convenient way to represent multiline strings in Java. A text block is a multi-line string literal that avoids the need for escape sequences and automatically formats the text in a readable way.
 */

public class TextBlock {
    public static void main(String[] args) {
        String textBlock= """
                {
                "name":"Abhijith",
                "age":"22"
                }
                """;
        System.out.println(textBlock);
    }


}
