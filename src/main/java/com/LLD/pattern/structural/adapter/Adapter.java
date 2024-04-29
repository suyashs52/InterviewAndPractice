package com.LLD.pattern.structural.adapter;

public class Adapter implements IAircraft {
//The adapter is composed with the Adaptee object, which in our case is the HotAirBalloon objec
    HotAirBalloon hotAirBalloon;

    public Adapter(HotAirBalloon hotAirBalloon) {
        this.hotAirBalloon = hotAirBalloon;
    }

    @Override
    public void fly() {
        String feulUsed = hotAirBalloon.inflateWithGas();
        hotAirBalloon.fly(feulUsed);
    }
}
