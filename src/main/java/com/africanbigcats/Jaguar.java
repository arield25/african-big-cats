package com.africanbigcats;

public class Jaguar extends Panthera {

    private boolean sleepsInTrees;

    public Jaguar(String name) {
        super(name);
        this.setSpecies("Jaguar");
        this.sleepsInTrees = true;
    }

    public String fur() {
        return "spots";
    }

    public boolean sleepsInTrees() {
        return sleepsInTrees;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", fur: " + fur() + ", sleepsInTrees: " + sleepsInTrees + " }");
    }
}
