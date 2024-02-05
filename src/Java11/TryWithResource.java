package Java11;

import java.io.FileOutputStream;

/**
 * auto-closed, a resource has to be both declared and initialized inside the try
 */
public class TryWithResource {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream =new FileOutputStream("src/Java11/file.txt")) {
            String msg = "TryWithResource";
            byte[] byteArray = msg.getBytes();
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfully!");
        }
      catch(Exception exception){
            System.out.println(exception.toString());
        }
    }
}
