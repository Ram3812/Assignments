package com.assignments.implementation;

import com.assignments.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component(value = "mrfTyres")
public class MrfTyres implements Tyres {
    @Override
    public void rotate() {
        System.out.println("Moving Vehicle using MRF Tyres");
    }
}
