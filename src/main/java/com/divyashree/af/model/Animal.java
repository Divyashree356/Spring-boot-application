package com.divyashree.af.model;

public class Animal {
     private String animalName;
     private  String fact;


    public Animal(String animalName, String fact)  {
        this.animalName = animalName;
        this.fact = fact;

    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }


}
