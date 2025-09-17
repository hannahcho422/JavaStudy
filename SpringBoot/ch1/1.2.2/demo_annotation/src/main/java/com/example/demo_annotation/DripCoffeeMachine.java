package com.example.demo_annotation;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component("dripCoffeeMachine")
@Primary
public class DripCoffeeMachine implements CoffeeMachine {
    @Override
    public String brew() {
        return "Brewing coffee with Drip Coffee Machine";
    }
}