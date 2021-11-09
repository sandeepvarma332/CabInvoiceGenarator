package org.blz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class InvoiceGeneratorTest {
    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double total_fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, total_fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_Should_then_ReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_Should_then_ReturnInvoiceSummary() {

        Rides[] rides = {new Rides(5.0, 2),
                new Rides(0.1, 1)};
        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(57, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {

        Rides[] rides = {new Rides(5.0, 5),
                new Rides(0.1, 1)};
        Invoice_Summary actualsummary = invoiceGenerator.calculateFareReturnSummary(rides);
        Invoice_Summary expectedSummary = new Invoice_Summary(2, 60);
        if (expectedSummary.getAverageFare() == actualsummary.getAverageFare() && expectedSummary.getNumberOfRides() == actualsummary.getNumberOfRides() && expectedSummary.getTotalFare() == actualsummary.getTotalFare())
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(1, 0);
    }

    @Test
    public void givenUserId_Should_then_ReturnInvoiceSummary_List() {

        String userId = "1";
        Invoice_List invoicelist = new Invoice_List();

        ArrayList<Rides> rides = new ArrayList<Rides>();
        rides.add(new Rides(5.0, 5));
        rides.add(new Rides(0.1, 1));

        invoicelist.addRides(userId, rides);
        ArrayList<Rides> listOfRides = invoicelist.getRides(userId);

        Invoice_Summary summaryForUser1 = invoiceGenerator.calculateFareReturnSummary(listOfRides);
        Invoice_Summary expectedSummary = new Invoice_Summary(2, 60);
        if (expectedSummary.getAverageFare() == summaryForUser1.getAverageFare() && expectedSummary.getNumberOfRides() == summaryForUser1.getNumberOfRides() && expectedSummary.getTotalFare() == summaryForUser1.getTotalFare())
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(1,0);
    }
}