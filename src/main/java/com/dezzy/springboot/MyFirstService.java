package com.dezzy.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstComponent firstComponent;

    public String getCustomProperty() {
        return customProperty;
    }

    @Value("${my.custom.property}")
    private String customProperty;

    public MyFirstService(MyFirstComponent firstComponent) {
        this.firstComponent = firstComponent;
    }

    public String tellAStory(){
        return "the dependency is saying : " + firstComponent.sayHello();
    }

}
