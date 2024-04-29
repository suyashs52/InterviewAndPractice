package com.LLD.pattern.structural.composite;

import com.LLD.pattern.creation.builder.IAircraft;

public class F16 implements IAlliancePart, IAircraft {

    @Override
    public int getPersonnel() {
        // We need 2 pilots for F-16
        return 2;
    }
}
