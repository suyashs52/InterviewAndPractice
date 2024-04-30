package com.LLD.pattern.behaviour.chain_of_responsibility;

public class LowFuelHandler extends AbstractHandler {

    // Only interested in handling requests with code 2
    private static int code = 2;

    public LowFuelHandler(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if (code == request.getRequestCode()) {
            // Handle the request here.
            System.out.println("Low Fuel Handled!");
        } else {
            // If the handler, doesn't handle these type of
            // requests, it can just call the super class's
            // forward request method.
            super.handleRequest(request);
        }
    }
}
