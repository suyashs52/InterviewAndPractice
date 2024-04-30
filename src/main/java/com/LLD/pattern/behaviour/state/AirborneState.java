package com.LLD.pattern.behaviour.state;

public class AirborneState  implements IPilotActions {
    public AirborneState(F16 f16) {
    }

    @Override
    public void pilotTaxies(F16 f16) {

    }

    @Override
    public void pilotFlies(F16 f16) {
        System.out.println("Airborne");
    }

    @Override
    public void pilotEjects(F16 f16) {
        System.out.println("Ejected");
    }

    @Override
    public void pilotLands(F16 f16) {

    }

    @Override
    public void pilotParks(F16 f16) {

    }
}
