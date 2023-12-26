package ua.edu.ucu.apps.lab11.task1;

public class Main 
{
    public static void main(String[] args)
    {
        User user = User.builder().name("JD").age(0).weight(78).height(2).gender("MALE").build();
        System.out.println(user);
    }
}
