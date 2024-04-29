package com.LLD.pattern.structural.composite;

import com.LLD.pattern.creation.builder.IAircraft;

public class C130Hercules implements IAircraft, IAlliancePart {

    @Override
    public int getPersonnel() {
        // This cargo plane, needs 5 people
        return 5;
    }
}
