package Problems;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//5.	Group strings by their length using groupingBy()
public class GroupStrByLength {
    public static void main(String[] args){

        List<String> names= Arrays.asList("Alice", "Bob", "Charlie");

        Map<Integer, List<String>>ans=names
                .stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(ans);
    }
}

/*
o/p
{3=[Bob], 5=[Alice], 7=[Charlie]}

 */