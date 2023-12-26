package ua.edu.ucu.apps.lab11.task3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProxyImage implements MyImage {
    private String filename;

    @Override
    public void display(){
        RealImage myImage = new RealImage(this.filename);
        myImage.display();
    }
}
