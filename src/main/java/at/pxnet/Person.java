package at.pxnet;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private final String id;
    private String name;
    private int age;
    private int[] grades;

    public Person(String id, String name, int age, int[] grades) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.name = Objects.requireNonNull(name, "Name cannot be null");

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;

        setGrades(grades); // Use setter to apply validation
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public void setGrades(int[] grades) {
        if (grades == null) {
            throw new IllegalArgumentException("Grades cannot be null");
        }
        //TEST
        for (int grade : grades) {
            if (grade < 1 || grade > 5) {
                throw new IllegalArgumentException("Grade must be between 1 and 5");
            }
        }
        this.grades = Arrays.copyOf(grades, grades.length);
    }
}

