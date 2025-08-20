package Problems;

import java.util.*;
import java.util.stream.Collectors;


//4.	Convert a list of strings to uppercase.
public class StringListToUpperCase {

    public static void main(String[] args){

        List<String> names=Arrays.asList("arpit","bob");

        List<String> ans=names.stream()
                .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(ans);
    }
}
/*
O/P
ARPIT,BOB
 */

