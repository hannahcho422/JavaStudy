package com.example.demo_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class CoffeeMaker {

    @Autowired
    @Qualifier("dripCoffeeMachine")
    // 외부에서 CoffeeMachine 구현체를 주입받음
    private CoffeeMachine coffeeMachine;

    @PostConstruct
    public void makeCoffee() {
        System.out.println(coffeeMachine.brew());
    }
}