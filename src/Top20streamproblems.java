
import java.util.*;
import java.util.stream.*;

public class Top20streamproblems {
        public static void main(String[] args) {

                // Q1. Given a list of integers, find all even numbers.
                // Brute force: iterate and add if num % 2 == 0.
                        List<Integer> nums = Arrays.asList(2, 5, 8, 3, 10, 13);
                        List<Integer>evenlist=nums.stream()
                                .filter(x->x%2==0)
                                .collect(Collectors.toList());
                        System.out.println("Even numbers:" +evenlist);


                // Q2. Given a list of integers, square each element.
                // Brute force: loop through and multiply num*num.
                         List<Integer>squareList=nums.stream().map(x->x*x)
                                .collect(Collectors.toList());
                         System.out.println("Square numbers:" +squareList);


                // Q3. Find all strings starting with letter 'A' (case-insensitive).
                // Brute force: loop and check startsWith("A") or startsWith("a").
                        List<String> names = Arrays.asList("Arpit", "Ravi", "anil", "Ramesh", "Asha");
                        List<String> letterStart=names.stream()
                                .filter(x->x.startsWith("A") || x.startsWith("a"))
                                .collect(Collectors.toList());
                        System.out.println("letterStart:"+ letterStart);


                // Q4. Given a list of strings, convert them all to uppercase.
                // Brute force: for loop and use .toUpperCase().
                         System.out.println("strings, convert them all to uppercase");
                        names.stream()
                                .map(x->x.toUpperCase())
                                .forEach(System.out::println);


                // Q5. Find the sum of all even numbers in a list.
                // Brute force: loop + if (n%2==0) sum+=n.
                        int sum=nums.stream().filter(x->x%2==0)
                                .reduce(0,Integer::sum );
                        System.out.println("Even Sum: "+sum);


                // Q6. Given a list of integers, find the maximum element.
                // Brute force: iterate and track max.
                       System.out.println("Given a list of integers, find the maximum element.");
                       Optional<Integer> ans=nums.stream()
                                .max(Comparator.naturalOrder());
                       ans.ifPresent(System.out::println);
                       //int max2=nums.stream().max(Comparator.naturalOrder()).get();


                // Q7. Find the first non-empty string in a list, else return "Not Found".
                // Brute force: loop and return the first s.trim().length()>0.
                        System.out.println("first non-empty string in a list");
                        List<String> emptyList=Arrays.asList("   Arp  ", "   ","Arpit");
                        String firstString=emptyList.stream()
                                .filter(s-> !s.trim().isEmpty())
                                .findFirst()
                                        .orElse("Not Found");
                                System.out.println(firstString);

                // Q8. Given a list of strings, count how many start with “A”.
                // Brute force: count++ for s starting with “A”.
                        System.out.println("count how many start with  'A'");
                        Long cnt=names.stream()
                                .filter(s->s.startsWith("A"))
                                .count();
                        System.out.println(cnt);

                // Q9. Sort a list of integers in ascending order.
                // Brute force: Collections.sort(list).
                        List<Integer> list=nums.stream()
                                .sorted()
                                .collect(Collectors.toList());
                        System.out.println("Integers in Ascending Order: "+list);


                // Q10. Sort a list of strings in descending order.
                // Brute force: Collections.sort(list, Collections.reverseOrder()).
                        List<Integer> list2=nums.stream()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());
                        System.out.println("Integers in Descending Order: "+list2);


                // Q11. Find distinct elements in a list.
                // Brute force: use a Set to eliminate duplicates.
                        List<Integer> dupNums = Arrays.asList(2, 3, 4, 2, 3, 5, 5, 7);
                        List<Integer> duplist=dupNums.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        System.out.println("List of Disctinct Integer: "+duplist);


                // Q12. Find the second highest number in a list.
                // Brute force: sort, remove duplicates, pick second last.
                        System.out.println("Second highest number in a list");
                        Optional<Integer> secondMax=nums.stream()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst();
                        secondMax.ifPresent(System.out::println);

                // Q13. Check if all numbers in a list are even.
                // Brute force: loop and check if any is odd.
                List<Integer> nums1 = Arrays.asList(2, 5, 8, 3, 10, 13);
                boolean allEven=nums1.stream()
                        .allMatch(x->x%2==0);
                System.out.println("All numbers in a list are even : "+allEven);


                // Q14. Check if any number is greater than 50.
                // Brute force: loop and if (n>50) return true.
                List<Integer> nums2 = Arrays.asList(2, 50, 51, 3, 10, 13);
                        boolean ans2=nums2.stream().anyMatch(x->x>50);
                System.out.println("Any number greater than 50 in the List : "+ans2);

                // Q15. Find average of all numbers.
                // Brute force: sum all and divide by size.
                OptionalDouble avg=nums2.stream()
                        .mapToInt(Integer::intValue).average();
                avg.ifPresent(System.out::println);


                // Q16. Concatenate all strings in a list separated by commas.
                // Brute force: StringBuilder + append().
                        String joined=names.stream()
                                .collect(Collectors.joining());
                System.out.println("Concatenate all strings in a list : "+joined);


                // Q17. Convert a list of strings to a map of string -> length.
                // Brute force: loop and put(s, s.length()).
                Map<String,Integer> map=names.stream()
                        .collect(Collectors.toMap(s->s,s->s.length()));
                System.out.println(map);


                // Q18. Given a list of numbers, group them by even or odd.
                // Brute force: two lists or a map with key “even”/“odd”.
                        Map<String,List<Integer>> groupList=nums2.stream()
                                .collect(Collectors.groupingBy(x->x%2==0?"Even":"Odd"));
                        System.out.println("list of numbers, group them by even or odd :"+groupList);


                // Q19. Find frequency of each element in a list.
                // Brute force: use a Map<Integer, Integer> counter.
                        Map<Integer,Long> freqMap=dupNums
                                .stream()
                                .collect(Collectors.groupingBy(x->x,Collectors.counting()));
                System.out.println("frequency of each element in a list. :"+freqMap);


                // Q20. Find the longest string in a list.
                // Brute force: track string with max length so far.
                System.out.println(" longest string in a list.");
                        names.stream()
                                .max(Comparator.comparing(String::length))
                                .ifPresent(System.out::println);

        }
}
