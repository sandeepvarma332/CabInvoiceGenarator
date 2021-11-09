package org.blz.cabinvoicegenerator;



import org.junit.Assert;
import org.junit.Test;

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
}