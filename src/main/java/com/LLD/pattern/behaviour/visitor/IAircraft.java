package com.LLD.pattern.behaviour.visitor;

public interface IAircraft {

    // Each concrete element class is expected to
    // define the accept method
    public void accept(IAircraftVisitor visitor);

}
