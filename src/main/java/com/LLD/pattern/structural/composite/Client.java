package com.LLD.pattern.structural.composite;

public class Client {

    public void main() {

        Airforce NatoAllaiance = new Airforce();

        // The nested methods aren't listed for brevity's sake
        NatoAllaiance.add(createCanadaAirForce());
        NatoAllaiance.add(createUSAAirForce());

        F16 frenchF16 = new F16();
        C130Hercules germanCargo = new C130Hercules();

        NatoAllaiance.add(frenchF16);
        NatoAllaiance.add(germanCargo);

        System.out.println(NatoAllaiance.getPersonnel());
    }

    private IAlliancePart createUSAAirForce() {
        return null;
    }

    private IAlliancePart createCanadaAirForce() {
        return null;
    }
}
