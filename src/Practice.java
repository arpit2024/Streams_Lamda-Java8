import java.util.*;
import java.time.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class Student {
    private Integer id;

    private String name;

    public Student(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class TestCollection {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Krisha"));
        studentList.add(new Student(2, "Aarya"));
        studentList.add(new Student(3, "Tisha"));
        studentList.add(new Student(3, "Ishana"));

        Map<Integer, String> studentMap = new HashMap<>();
        // Add the Code Changes After This





        studentMap.forEach(
                (x, y) -> System.out.println("Student ID : " + x + ", Student Name : " + y));
    }
}
