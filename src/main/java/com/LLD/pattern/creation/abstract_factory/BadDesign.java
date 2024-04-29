package com.LLD.pattern.creation.abstract_factory;

import java.util.ArrayList;
import java.util.List;

public class BadDesign {

    public void main() {
        F16Cockpit f16Cockpit = new F16Cockpit();
        F16Engine f16Engine = new F16Engine();
        F16Wings f16Wings = new F16Wings();

        List<F16Engine> engines = new ArrayList<>();
        engines.add(f16Engine);
        for (F16Engine engine : engines) {
            engine.start();
        }
    }
    //The concrete classes for the three parts have been directly exposed to the consumer.
    //F-16 has several variants  you'll need to subclass F16Engine  that would necessitate a change in the consumer snippet too.
    //
}
