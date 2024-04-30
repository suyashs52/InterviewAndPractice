package com.LLD.pattern.behaviour.state;

public class NorRight {

    // Pilot takes the taxi action,in the absence of the state pattern. We'll code the state transition function when the pilot takes the taxi action.
    public void pilotTaxies(String currentState) {

        if (currentState == "Parked") {

            currentState = "Taxi";
            System.out.println("Plane is taxing on the runway.");

        } else if (currentState == "Airborne") {

            System.out.println("This is an invalid operation for this state");

        } else if (currentState == "Land") {

            System.out.println("This is an invalid operation for this state");

        } else if (currentState == "Crashed") {

            System.out.println("This is an invalid operation for this state");

        } else if(currentState == "Taxi"){
            System.out.println("Plane is already taxing on the runway.");
        }

    }
}
