package com.microsoft.aop.annoAOP;

import org.springframework.stereotype.Component;

@Component
public class Calculate {
    public void add() {
        System.out.println("Calculate add.....");
    }
}
