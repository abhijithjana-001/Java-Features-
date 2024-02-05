package Java17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collectors.teeing
 * collectors.toList
 * It is a new static method teeing to java.util.stream.Collectors interface which allows to collect using two independent collectors, then merge their results using the supplied BiFunction.
 */
public class CollectorsTeeing {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);
        Integer collect = list.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Integer::min),
                        Collectors.maxBy(Integer::max),
                        (min, max) -> min.get() + max.get()
                )
        );
        System.out.println(collect);

       List<Integer>integers= Stream.of(1,2,3,4,5).toList();
    }
}
