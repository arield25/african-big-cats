package com.africanbigcats;

public class Tiger extends Panthera {

    public Tiger(String name) {
        super(name);
        this.setSpecies("Tiger");
    }

    public String fur() {
        return "stripes";
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", fur: " + fur() + " }");
    }
}
