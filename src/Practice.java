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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

        // ✅ Approach 1: Normal for-each (using HashMap)
        Map<Integer, String> studentMap = new HashMap<>();

        for (Student s : studentList) {
            // If duplicate key exists, overwrite or handle however you want
            studentMap.put(s.getId(), s.getName());
        }

        System.out.println("Normal Map Output:");
        studentMap.forEach((id, name) ->
                System.out.println("Student ID : " + id + ", Student Name : " + name));

        // ✅ Approach 2: Java 8 Streams
        // Using toMap with a merge function to handle duplicate keys
        Map<Integer, String> studentMapStream = studentList.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        Student::getName,
                        (oldValue, newValue) -> newValue // keep latest on duplicate
                ));

        System.out.println("\nStream Map Output:");
        studentMapStream.forEach((id, name) ->
                System.out.println("Student ID : " + id + ", Student Name : " + name));
    }
}
