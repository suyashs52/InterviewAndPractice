package com.LLD.pattern.behaviour.state;

public class Client {

    public static void main(String[] args) {



        F16 f16 = new F16();
        f16.startsEngine();
        f16.fliesPlane();
        f16.ejectsPlane();

    }
}
