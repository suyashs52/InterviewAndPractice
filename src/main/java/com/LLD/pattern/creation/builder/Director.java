package com.LLD.pattern.creation.builder;

import javax.xml.parsers.DocumentBuilder;

public class Director {
    AircraftBuilder aircraftBuilder;
    DocumentBuilder documentBuilder;

    public Director(AircraftBuilder aircraftBuilder) {
        this.aircraftBuilder = aircraftBuilder;
    }

    public void construct(boolean isPassenger) {
        aircraftBuilder.buildCockpit();
        aircraftBuilder.buildEngine();
        aircraftBuilder.buildWings();

        if (isPassenger)
            aircraftBuilder.buildBathrooms();
    }
}
