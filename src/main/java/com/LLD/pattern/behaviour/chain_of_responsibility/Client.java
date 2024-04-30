package com.LLD.pattern.behaviour.chain_of_responsibility;

//fnally the interaction between these different classes is exhibited in the client code.

public class Client {

    public static void main(String[] args) {


        // Setup the chain like so:
        // FireHandler --> LowFuelHandler --> null
        // The chain has just two handlers with the firstHandler
        // at the head of the chain.
        AbstractHandler lowFuelHandler = new LowFuelHandler(null);
        FireHandler fireHandler = new FireHandler(lowFuelHandler);

        // Create a emergency request that the airplane is running low
        // on fuel.
        LowFuelRequest lowFuelRequest = new LowFuelRequest();

        // Let the chain handle the request
        fireHandler.handleRequest(lowFuelRequest);
    }
}
