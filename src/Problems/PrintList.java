package Problems;

import java.util.Arrays;
import java.util.List;


//1.    Print a list using Lambda Expressions
public class PrintList {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name->System.out.println(name));


    }
}
/*
O/P
Alice
Bob
Charlie
 */