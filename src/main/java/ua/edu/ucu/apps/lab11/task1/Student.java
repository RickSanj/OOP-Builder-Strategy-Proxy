package ua.edu.ucu.apps.lab11.task1;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import lombok.ToString;
import lombok.Singular;
import java.util.List;

@SuperBuilder(toBuilder=true)
@ToString
public class Student extends User{
    @Singular
    private List<Integer> grades;
}
