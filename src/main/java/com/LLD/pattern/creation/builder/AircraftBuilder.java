package com.LLD.pattern.creation.builder;

public abstract class AircraftBuilder {
    private String model;
    private String manufacturer;

    public void buildEngine() {

    }

    public void buildWings() {

    }

    public void buildCockpit() {

    }

    public void buildBathrooms() {

    }

    abstract public IAircraft getResult();

    public Aircraft build() {
        return new Aircraft(model, manufacturer);
    }

    public String model() {
        return model;
    }

    public AircraftBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public String manufacturer() {
        return manufacturer;
    }

    public AircraftBuilder setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
}
