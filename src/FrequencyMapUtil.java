import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyMapUtil {

    public static Map<Character, Long> getFrequencyMap(String input, String sortType) {
        // Step 1: Create the unsorted frequency map
        Map<Character, Long> freqMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Sort according to sortType
        switch (sortType.toLowerCase()) {
            case "key": // Sort alphabetically by character
                return freqMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

            case "value": // Sort by frequency, highest first
                return freqMap.entrySet().stream()
                        .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

            case "insertion": // Keep order of first appearance
                return input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ));

            default:
                throw new IllegalArgumentException("Invalid sort type. Use 'key', 'value', or 'insertion'.");
        }
    }
    //here’s a reusable method that gives you a sorted frequency map in any of the
    // three ways ("key", "value", or "insertion") just by passing a parameter.
    public static void main(String[] args) {
        String inputString = "banana";

        System.out.println("By Key: " + getFrequencyMap(inputString, "key"));
        System.out.println("By Value: " + getFrequencyMap(inputString, "value"));
        System.out.println("By Insertion: " + getFrequencyMap(inputString, "insertion"));
    }
}
