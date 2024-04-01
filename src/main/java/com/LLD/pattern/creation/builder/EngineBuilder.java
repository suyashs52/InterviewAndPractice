package com.LLD.pattern.creation.builder;

public class EngineBuilder {

    private String type;
    private int thrust;

    public String type() {
        return type;
    }

    public Engine build(){
        return new Engine(type,thrust);
    }
    public EngineBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public int thrust() {
        return thrust;
    }

    public EngineBuilder setThrust(int thrust) {
        this.thrust = thrust;
        return this;
    }
}
