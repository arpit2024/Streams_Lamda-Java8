package Problems;

import java.util.*;
import java.util.stream.Collectors;


//2.	Filter even numbers from a list using Streams
public class evenNumber {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
/*
O/P
[2, 4, 6]
 */
