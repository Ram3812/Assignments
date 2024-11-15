package com.assignments.implementation;

import com.assignments.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component(value = "BoseSpeakers")
public class BoseSpeakers implements Speakers {
    @Override
    public void playMusic() {
        System.out.println("Playing Music From Bose Speakers");
    }
}
