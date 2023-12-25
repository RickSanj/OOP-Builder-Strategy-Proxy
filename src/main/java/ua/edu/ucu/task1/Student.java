package demo.src.main.java.ua.edu.ucu.task1;

import lombok.Builder;
import lombok.SuperBuilder;
import lombok.ToString;
import lombok.Singular;
import java.util.List;

@SuperBuilder
@ToString
public class Student extends User{
    @Singular
    private List<Integer> grades;
}
