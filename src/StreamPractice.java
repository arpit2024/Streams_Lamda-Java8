import java.lang.reflect.Array;
import java.util.*;
import java.time.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {

        // Integer List for most operations
        List<Integer> listOfIntegers = Arrays.asList(10, 25, 5, 40, 55, 2, 99, 50, 15, 5, 25, 99);

        // String List for string-based stream operations
        List<String> listOfStrings = Arrays.asList("apple", "banana", "apple", "grapes", "orange", "banana", "kiwi");

        //List for reverse order
        List<Integer> sortlist = List.of(1, 2, 3, 4, 5, 6);

        // Two Arrays for merging and comparing
        int[] a = {5, 2, 8, 10};
        int[] b = {1, 6, 2, 10};

        // Another List for checking common elements
        List<String> list1 = Arrays.asList("Java", "Spring", "Hibernate", "SQL");
        List<String> list2 = Arrays.asList("Spring", "Hibernate", "AWS", "Docker");

        // Array for sum/average
        int[] inputArray = {10, 20, 30, 40, 50};

        // String input for character frequency, reverse words, etc.
        String inputString = "programming";

        // Integer for sum of digits
        int inputNumber = 12345;

        // Strings for anagram check
        String s1 = "listen";
        String s2 = "silent";

        // String input for reverse word
        String str = "Java 8 Stream API Questions";

        // Integer array for second largest number
        List<Integer> listWithDuplicates = Arrays.asList(4, 5, 2, 8, 6, 1, 9, 8, 3);

        // Birth date for age calculation
        LocalDate birthDay = LocalDate.of(1985, 1, 23);
        LocalDate today = LocalDate.now();

//------------------------------------------------------------------------------------------------

        System.out.println("Separate odd and even numbers from a list.");
            Map<Boolean,List<Integer>> list=listOfIntegers.stream()
                    .collect(Collectors.partitioningBy(i->i%2==0));
            System.out.println(list.get(true));
            System.out.println(list.get(false));
//----------------------------------------------------------------------------------------
        System.out.println("Remove duplicate elements from a list.");
            listOfIntegers.stream()
                            .distinct()
                            .forEach(System.out::println);
//----------------------------------------------------------------------------------------
        //Ex:- Type 1
        System.out.println("Frequency of each character in str programming.(After finding the freq we are putting ans in FreqMap.)");
            Map<Character, Long> freqMap=inputString.chars()
                            .mapToObj(c->(char)c)
                            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            System.out.println(freqMap);
        System.out.println("(Sorting a Map)Here freq operation is not done,just sorting and printing the Above Map");
            freqMap.entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(k->System.out.println(k.getKey()+":"+k.getValue()));
        //Ex:- Type 2
        System.out.println("Frequency of each character in str programming in insertion order");
            LinkedHashMap<Character,Long> InsertOrderFreq=inputString.chars()
                    .mapToObj(c->(char)c)
                            .collect(Collectors.groupingBy(Function.identity()
                            ,LinkedHashMap::new
                            ,Collectors.counting()));
            System.out.println(InsertOrderFreq);
        //Ex:- Type 3
        System.out.println("to get a sorted map while collecting, you have to collect, sort, and then re-collect into a LinkedHashMap.");
            Map<Character,Long> SortedFreq=inputString.chars()
                    .mapToObj(c->(char)c)
                            .collect(Collectors.
                                    groupingBy(Function.identity(),
                                    Collectors.counting()))
                                    .entrySet().stream()
                                    .sorted(Map.Entry.comparingByKey())
                                    .collect(Collectors.toMap(
                                            Map.Entry::getKey,
                                            Map.Entry::getValue,
                                            (e1,e2)->e1,
                                            LinkedHashMap::new
                                    ));
            System.out.println(SortedFreq);
//----------------------------------------------------------------------------------------
        System.out.println("Frequency of each element in an array.");
            System.out.println(listOfStrings.stream().
                    collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
//----------------------------------------------------------------------------------------
        System.out.println("Sort the list in reverse order.");
            //List<Integer> ans;
                    sortlist.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
            //System.out.println("reverse sorted"+ ans);
//----------------------------------------------------------------------------------------
        System.out.println("Print multiples of 5 from the list.");
            List<Integer> multiples=listOfIntegers.stream()
                    .filter(n->n%5==0)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println("multiples"+ multiples);
//----------------------------------------------------------------------------------------
        System.out.println("Merge two unsorted arrays into a single sorted array.");
            int[] arr= IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                      .sorted().toArray();
              System.out.println(Arrays.toString(arr));
//----------------------------------------------------------------------------------------
        System.out.println("Merge two unsorted arrays into a single sorted array without duplicates.");
            int[] distinctArr=IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                    .sorted()
                    .distinct()
                    .toArray();
            System.out.println(Arrays.toString(distinctArr));
//----------------------------------------------------------------------------------------
        System.out.println("Find three min numbers from the list");
            List<Integer> minList=listOfIntegers.stream()
                            .sorted()
                            .distinct()
                            .limit(3)
                            .collect(Collectors.toList());
            System.out.println(minList);
//----------------------------------------------------------------------------------------
       System.out.println("Find three max numbers from the list");
            List<Integer> maxList=listOfIntegers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
            System.out.println(maxList);
//----------------------------------------------------------------------------------------
       System.out.println("Join list of strings with prefix, suffix, and delimiter.");
            String joinedString = listOfStrings.stream()
                .collect(Collectors.joining(", ", "Prefix: ", " :Suffix"));
            System.out.println(joinedString);
//----------------------------------------------------------------------------------------
       System.out.println( "Find maximum and minimum in a list.");
            System.out.println(listOfIntegers.stream()
                    .max(Comparator.naturalOrder())
                    .get());
//----------------------------------------------------------------------------------------
       System.out.println("Check if two strings are anagrams (case-insensitive)");
            boolean isAnagram=Arrays.equals(s1.chars().sorted().toArray(),s2.chars().sorted().toArray());
            System.out.println(isAnagram);
//----------------------------------------------------------------------------------------System.out.println("sum of all digits of a number- 12345 ");
            System.out.println(
                Stream.of(String.valueOf(inputNumber).split(""))
                .collect(Collectors.summingInt(Integer::parseInt))
            );
//----------------------------------------------------------------------------------------
       System.out.println("second largest number in an integer array. ");
             System.out.println(
                     listOfIntegers.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .get()
             );
//----------------------------------------------------------------------------------------
       System.out.println("Sort list of strings in increasing order of their length.");
                 List<String> lenSortedList= listOfStrings.stream()
                        .distinct()
                        .sorted(Comparator.comparing(String::length))
                        .collect(Collectors.toList());
                System.out.println(lenSortedList);
//----------------------------------------------------------------------------------------
//        Find common elements between two arrays.

//        Find sum and average of all elements of an array.

//        Reverse each word of a string.

//        Find sum of first 10 natural numbers.

//        Reverse an integer array.

//        Check if a string is a palindrome.

//        Find strings that start with a number.

//        Find duplicate elements from an array.

//        Find the last element of an array.

//        Calculate the age of a person in years from birth date.

//        Generate Fibonacci series using streams.

    }
}
