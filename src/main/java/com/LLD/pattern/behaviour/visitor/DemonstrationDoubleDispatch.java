package com.LLD.pattern.behaviour.visitor;

public class DemonstrationDoubleDispatch {

    public static void main( String args[] ) {
        F16 f16 = new F16();
        f16.whoAmI();

        System.out.println();

        // Reference for the derived object
        // is held in the superclass type
        F16 betterF16 = new BetterF16();
        betterF16.whoAmI();
    }
}
