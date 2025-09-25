package com.africanbigcats;

import java.util.Random;

/**
 * PantheraGPS base class
 * Simulates GPS tracking of big cats.
 */
public class PantheraGPS {

    // constants
    private final Integer maxLongitude = 1000;
    private final Integer maxLatitude = 1000;
    protected final float minSpeed = 0f;
    protected final float maxSpeed = 50.0f;

    // attributes
    private String name;
    private String species;
    private Float longitude;
    private Float latitude;
    private Random longitudeRandom;
    private Random latitudeRandom;

    // constructor
    public PantheraGPS(String name) {
        this.name = name;
        this.species = "PantheraGPS";

        // seed random number generators for repeatable results
        this.longitudeRandom = new Random();
        this.longitudeRandom.setSeed(this.seed(name + "longitude"));

        this.latitudeRandom = new Random();
        this.latitudeRandom.setSeed(this.seed(name + "latitude"));

        // initial position
        this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        this.latitude = latitudeRandom.nextFloat() * maxLatitude;
    }

    // serializes attributes into JSON-like string
    @Override
    public String toString() {
        return "{ name: " + name +
               ", species: " + this.species +
               ", longitude: " + this.longitude +
               ", latitude: " + this.latitude +
               " }";
    }

    // getters
    public String name() {
        return this.name;
    }

    public String species() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // create a seed based on the name string
    private Integer seed(String s) {
        Integer seed = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }
        return seed;
    }

    // move the cat to a new GPS position
    public void move() {
        this.longitude += longitudeRandom.nextFloat() * maxSpeed;
        this.latitude += latitudeRandom.nextFloat() * maxSpeed;
    }

    // longitude of the cat
    public Float longitude() {
        return longitude;
    }

    // latitude of the cat
    public Float latitude() {
        return latitude;
    }
}
