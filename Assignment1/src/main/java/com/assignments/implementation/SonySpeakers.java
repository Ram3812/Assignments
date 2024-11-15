package com.assignments.implementation;

import com.assignments.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "sonySpeakers")
@Primary
public class SonySpeakers implements Speakers {
    @Override
    public void playMusic() {
        System.out.println("Playing Music From Sony Speakers");
    }
}
