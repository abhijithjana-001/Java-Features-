package Java21;

import java.util.Arrays;
import java.util.List;

/**
 * Introduce new interfaces to represent collections with a defined encounter order. Each such collection has a well-defined first element, second element, and so forth, up to the last element. It also provides uniform APIs for accessing its first and last elements, and for processing its elements in reverse order.
 */
public class SequencedCollections {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);


        System.out.println(list.getFirst());
        System.out.println(list.getLast());

//
//       list.removeFirst();
//        System.out.println(list);
//     list.removeLast();
//        System.out.println(list);

        List<Integer> reversed = list.reversed();
        System.out.println(reversed);



    }
}
