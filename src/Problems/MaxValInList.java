package Problems;

import java.util.*;
import java.util.stream.Collectors;

//3.	Find the maximum value in a list using Streams

public class MaxValInList {
    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(10,20,30,40,50);

        int max=list.stream()
                .max(Integer::compare)
                .orElse(0);

        System.out.println(max);

    }
}
/*

O/P
50

*/

