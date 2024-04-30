package com.LLD.pattern.behaviour.state;

public class TaxiState  implements IPilotActions {
    public TaxiState(F16 f16) {
    }

    @Override
    public void pilotTaxies(F16 f16) {

    }

    @Override
    public void pilotFlies(F16 f16) {
        f16.setState(f16.getAirborneState());
    }

    @Override
    public void pilotEjects(F16 f16) {
        f16.setState(f16.getCrashState());
    }

    @Override
    public void pilotLands(F16 f16) {

    }

    @Override
    public void pilotParks(F16 f16) {

    }
}
