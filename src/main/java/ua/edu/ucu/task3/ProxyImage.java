package main.java.ua.edu.ucu.task1.task3;

import demo.src.main.java.ua.edu.ucu.task3.MyImage;
import demo.src.main.java.ua.edu.ucu.task3.RealImage;

public class ProxyImage implements MyImage {
    private String filename;
    public ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display(){
        MyImage myImage = new RealImage(this.filename);
        myImage.display();
    }
}
