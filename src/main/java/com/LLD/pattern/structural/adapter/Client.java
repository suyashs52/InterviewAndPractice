package com.LLD.pattern.structural.adapter;

public class Client {

    public void main() {
        //Object Adapter

        HotAirBalloon hotAirBalloon = new HotAirBalloon();
        Adapter hotAirBalloonAdapter = new Adapter(hotAirBalloon);

        hotAirBalloonAdapter.fly();
        //client can now make a hot air balloon fly even though it deviates from the fly() method enforced by the IAircraft interface.
    }

}
