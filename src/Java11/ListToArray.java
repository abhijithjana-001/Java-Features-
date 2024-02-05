package Java11;

import java.util.Arrays;
import java.util.List;

/**
 * list.toArray method -> convert list to array
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("Java","Python","Go");

        String[] array=list.toArray(String[]::new);
    }
}
