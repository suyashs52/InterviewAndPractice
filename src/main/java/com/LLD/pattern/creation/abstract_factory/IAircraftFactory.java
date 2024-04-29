package com.LLD.pattern.creation.abstract_factory;

public interface IAircraftFactory {

    IEngine createEngine();

    IWings createWings();

    ICockpit createCockpit();
}
