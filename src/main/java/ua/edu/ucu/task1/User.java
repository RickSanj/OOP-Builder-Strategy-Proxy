package demo.src.main.java.ua.edu.ucu.task1;

import lombok.Builder;
import lombok.ToString;
import lombok.SuperBuilder;
// @Singular private final List<String> interests;
@SuperBuilder
@ToString
public class User {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;
}
