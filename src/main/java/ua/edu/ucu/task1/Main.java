package demo.src.main.java.ua.edu.ucu.task1;

import demo.src.main.java.ua.edu.ucu.task1.User;
public class Main 
{
    public static void main(String[] args)
    {
        User user = User.builder().name("JD").age(0).weight(78).height(2).gender("MALE").build();
        System.out.println(user);
    }
}
