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

    public List<Person> getStudent() {
        return Collections.unmodifiableList(students);
    }

    public List<Person> getFaillingStudents() {
        List<Person> failing = new ArrayList<>();
        for (Person student : students) {
            if(Grading.isFailing(student)) {
                failing.add(student);
            }
        }
        return Collections.unmodifiableList(failing);
    }

    public double getAverageAge() {
        if (students.isEmpty()) {
            return 0;
        }
        int totalAge = 0;
        for (Person student : students) {
            totalAge += student.getAge();
        }
        return totalAge / (double)students.size();
    }

}
