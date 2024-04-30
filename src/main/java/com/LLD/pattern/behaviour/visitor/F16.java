package com.LLD.pattern.behaviour.visitor;

public class F16 implements IAircraft {

    @Override
    public void accept(IAircraftVisitor visitor) {
        visitor.visitF16(this);
    }

    public void whoAmI(){
        System.out.print("I am the mighty F-16.");
    }
}
