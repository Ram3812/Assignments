package com.assignments.implementation;

import com.assignments.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "michTyres")
@Primary
public class MichTypres implements Tyres {
    @Override
    public void rotate() {
        System.out.println("Moving Vehicle using Mich Tyres");
    }
}
