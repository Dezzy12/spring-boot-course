package com.dezzy.springboot;

import org.springframework.stereotype.Component;

public class MyFirstComponent {

    private String myVar;

    public MyFirstComponent(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return ("Hello from the MyFirstComponent ==> myVar = " + myVar);
    }
}
