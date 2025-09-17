package com.example.demo_annotation;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component("espressoMachine")
@Primary
public class EspressoMachine implements CoffeeMachine {
    @Override
    public String brew() {
        return "Brewing coffee with Espresso Machine";
    }
}