package org.blz.cabinvoicegenerator;

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final int COST_PER_TIME = 1;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double MINIMUM_FARE = 5;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    public double calculateFare(double distance, int time, String user) {
        double totalFare = 0.0;
        if (user.equalsIgnoreCase("normal")) {
            totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
            if (totalFare < MINIMUM_FARE)
                return MINIMUM_FARE;
        }
        if (user.equalsIgnoreCase("premium")) {
            totalFare = distance * PREMIUM_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
            if (totalFare < MINIMUM_FARE)
                return PREMIUM_MINIMUM_FARE;
        }
        return totalFare;
    }

    public double calculateFare(Rides[] rides) {

        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time, ride.user);
        }
        return totalFare;
    }

    public Invoice_Summary calculateFareReturnSummary(Rides[] rides) {

        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time, ride.user);
        }
        return new Invoice_Summary(rides.length, totalFare);
    }

    public Invoice_Summary calculateFareReturnSummary(ArrayList<Rides> rides) {

        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time, ride.user);
        }
        return new Invoice_Summary(rides.size(), totalFare);
    }
}