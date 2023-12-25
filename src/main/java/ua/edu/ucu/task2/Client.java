import lombok.Builder;
import lombok.ToString;


public enum Gender {
    MALE, FEMALE
}

@ToString
public class Client {
    private int id;
    private static int counter;
    private String name;
    private int age;
    private Gender sex;
    private String email;

    @Builder
    public Client(String name, int age, Gender sex, String email) {
        id = counter++;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Gender getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
}
