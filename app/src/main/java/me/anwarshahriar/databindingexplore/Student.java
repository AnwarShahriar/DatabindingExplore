package me.anwarshahriar.databindingexplore;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> courses;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public String getCourseSummary() {
        StringBuilder builder = new StringBuilder(courses.size());
        for (int i = 0, size = courses.size(); i < size; i++) {
            builder.append(courses.get(i));
            if ( i < size - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
