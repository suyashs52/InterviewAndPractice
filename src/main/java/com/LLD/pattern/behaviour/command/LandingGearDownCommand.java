package com.LLD.pattern.behaviour.command;

public class LandingGearDownCommand implements Command {

    // This is called the receiver of the request and
    // actually has the logic to perform the action
    // landingGear in the LandingGearDownCommand class. This is called the Receiver.
    // It is the object that actually knows how to lower the landing gear and does the job,
    // which is why it is called the receiver because it receives the request and processes it.
    LandingGear landingGear;

    public LandingGearDownCommand(LandingGear landingGear) {
        this.landingGear = landingGear;
    }

    @Override
    public void execute() {
        landingGear.up();
    }
}
