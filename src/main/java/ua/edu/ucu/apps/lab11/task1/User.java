package ua.edu.ucu.apps.lab11.task1;

import lombok.Builder;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder=true)
@ToString
public class User {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;
}
