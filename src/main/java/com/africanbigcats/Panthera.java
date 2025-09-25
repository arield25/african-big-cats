package com.africanbigcats;

import java.util.Random;

public class Panthera extends PantheraGPS {

    private int weight; // in pounds
    private Random speedRandom;

    public Panthera(String name) {
        super(name);
        this.setSpecies("Panthera");
        this.weight = new Random().nextInt(591) + 10; // 10 to 600 lbs
        this.speedRandom = new Random();
    }

    public int getWeight() {
        return weight;
    }

    public float speed() {
        return speedRandom.nextFloat() * 50; // 0.0 to 50.0 mph
    }

    public void roar() {
        System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
    }

    @Override
    public String toString() {
        return "{ name: " + name() +
                ", species: " + species() +
                ", weight: " + weight +
                ", speed: " + String.format("%.2f", speed()) +
                ", longitude: " + longitude() +
                ", latitude: " + latitude() +
                " }";
    }
}
