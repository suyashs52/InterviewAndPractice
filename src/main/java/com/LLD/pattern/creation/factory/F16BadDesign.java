package com.LLD.pattern.creation.factory;

public class F16BadDesign {

    F16Engine engine;
    F16Cockpit cockpit;

    protected void makeF16() {
        engine = new F16Engine();
        cockpit = new F16Cockpit();
    }

    public void fly() {
        makeF16();
        System.out.println("F16 with bad design flying");
    }


    public void main() {

        // We instantiate from a concrete class, thus tying
        // ourselves to it
        F16BadDesign f16 = new F16BadDesign();
        f16.fly();
    }
//if the company comes up with newer versions of the aircraft
// That would make us change the client code where we new-up the F16 instance.
    public F16 makeF16(String variant) {
        //simple factory design
        switch (variant) {
            case "A":
                return new F16A();
            case "B":
                return new F16B();
            default:
                return new F16();
        }
    }
}
