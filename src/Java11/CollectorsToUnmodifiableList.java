package Java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Collectors.toUnmodifiableList()->return an unmodifiable  list
 *   Predicated.not method  it use to negate existing Predicated
 */
public class CollectorsToUnmodifiableList {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());

        collect.add( 8);//this will throw an unsupportedOperationException


        List<Integer> oddNumber = list.stream()
                .filter(Predicate.not(i -> i % 2 == 0)).toList();
        System.out.println(oddNumber);

    }
}
