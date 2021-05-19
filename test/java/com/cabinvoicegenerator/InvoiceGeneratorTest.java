package com.cabinvoicegenerator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator;

    @Before
    public void setUp() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        int time = 9;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(59, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.01;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.01, 1)};
        InvoiceSummary summary = cabInvoiceGenerator.returnRideSummary(rides);
        InvoiceSummary checkSummary = new InvoiceSummary(2,30.0);
    }
}
