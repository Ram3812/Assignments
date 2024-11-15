package com.assignments.services;

import com.assignments.interfaces.Speakers;
import com.assignments.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {
    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(@Qualifier("mrfTyres")Tyres tyres) {
        this.tyres = tyres;
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public void playMusic() {
        speakers.playMusic();
    }

    public void moveVehicle() {
        tyres.rotate();
    }
}
