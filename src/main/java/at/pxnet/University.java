package at.pxnet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private final List<Person> students = new ArrayList<>();

    public void addStudent(Person person) {
        if (!students.contains(person)) {
            students.add(person);
        }
    }

    public void removeStudent(Person person) {
        students.remove(person);
    }

    // Fixed method name to match expected `getStudents()`
    public List<Person> getStudents() {
        return Collections.unmodifiableList(students);
    }

    // Fixed typo in "getFaillingStudents" → "getFailingStudents"
    public List<Person> getFailingStudents() {
        List<Person> failing = new ArrayList<>();
        for (Person student : students) {
            if (Grading.isFailing(student)) {
                failing.add(student);
            }
        }
        return Collections.unmodifiableList(failing);
    }

    public double getAverageAge() {
        if (students.isEmpty()) {
            return 0;
        }
        //Test
        int totalAge = students.stream().mapToInt(Person::getAge).sum(); // Stream API for better readability
        return totalAge / (double) students.size();
    }
}

