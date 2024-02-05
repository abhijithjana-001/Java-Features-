package Java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * writeString(): This is to write some content in a file.
 * readString(): This is used to read the contents of a file.
 * isSameFile(): This method is used to know whether two paths locate the same file or not.
 */
public class NewFileMethods {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("src/Java11/file.txt");
        Files.writeString(path,"writing");

        System.out.println(Files.readString(path));

        System.out.println(Files.isSameFile(path,path));

    }
}
