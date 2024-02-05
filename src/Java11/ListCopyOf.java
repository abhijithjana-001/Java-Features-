package Java11;

import java.util.Arrays;
import java.util.List;

/**
 * List.CopyOf method return an unmodifiable copy version of the given collection
 */
public class ListCopyOf {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        List<Integer> copyList=List.copyOf(list);

        copyList.add(6);//this will throw an unsupportedOperationException

    }
}
