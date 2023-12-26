package ua.edu.ucu.apps.lab11.task2;

import lombok.Builder;
import lombok.ToString;


@ToString
public class Client {
    private int id;
    private static int counter;
    private String name;
    private int age;
    private String sex;
    private String email;

    @Builder
    public Client(String name, int age, String sex, String email) {
        id = counter++;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
}
