package com.africanbigcats;

public class Lion extends Panthera {

    public Lion(String name) {
        super(name);
        this.setSpecies("Lion");
    }

    public String fur() {
        return "mane";
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", fur: " + fur() + " }");
    }
}
