package com.ensa.gi4.modele;

import org.springframework.stereotype.Component;

@Component
public abstract class Materiel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
