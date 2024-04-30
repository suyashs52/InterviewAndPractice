package com.LLD.pattern.behaviour.chain_of_responsibility;

public class LowFuelRequest extends AbstractRequest {

    // Low on fuel request is assigned code of 2
    public LowFuelRequest() {
        super(2);
    }
}
