package com.cabinvoicegenerator;

public class CabInvoiceGenerator {
    private static final double COST_PER_KM = 10.0;
    private static final int COST_PER_MINUTE = 1;
    private static final double MIN_FARE = 5.0;
    RideRepository rideRepository;

    public CabInvoiceGenerator() {
        rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(totalFare, MIN_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.distance * COST_PER_KM + ride.time * COST_PER_MINUTE;
        }
        return totalFare;
    }

    public InvoiceSummary returnRideSummary(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int numberOfRides = rides.length;
        return new InvoiceSummary(numberOfRides, totalFare);
    }

    public InvoiceSummary invoiceForUser(String userId) {
        return calculateFare(rideRepository.getRidesForUser(userId));
    }

    public void addRideToRepository(String[] userId, Ride[][] rides) throws CabInvoiceException {
        for(int i = 0; i < userId.length; i++) {
            rideRepository.addRideForUser(userId[i], rides[i]);
        }
    }
}
