package at.pxnet;

import java.util.Arrays;

public class Person {
    private final String id;
    private String name;
    private int age;
    private int[] grades;

    public Person(String id, String name, int age, int[] grades) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
    }
//TEST
    private void setGrades(int[] grades) {
        if (grades == null) {
            throw new IllegalArgumentException("grades cannot be null");
        }
        for (int grade : grades) {
            if (grade < 1 || grade > 5) {
                throw new IllegalArgumentException("grade must be between 1 and 5");
            }
        }
        this.grades = Arrays.copyOf(grades, grades.length);
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
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

