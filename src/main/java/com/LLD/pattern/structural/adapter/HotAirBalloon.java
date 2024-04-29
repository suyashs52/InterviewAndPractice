package com.LLD.pattern.structural.adapter;

public class HotAirBalloon {

    String gasUsed = "Helium";

    void fly(String gasUsed) {
        // Take-off sequence based on the kind of feul
        // Followed by more code.
    }

    // Function returns the gas used by the balloon for flight
    String inflateWithGas() {
        return gasUsed;
    }
}