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

    @Test
    public void givenData_ReturnInvoiceSummary() throws CabInvoiceException {
        String[] userId = {"Amit","Aman","Sam"};
        Ride[][] rides = {{new Ride(5.0, 12), new Ride(2.5, 6)},
                {new Ride(3.0, 5), new Ride(0.01, 1)},
                {new Ride(10.0, 15), new Ride(2, 30)}};
        cabInvoiceGenerator.addRideToRepository(userId, rides);
        InvoiceSummary summary = cabInvoiceGenerator.invoiceForUser(userId[2]);
        InvoiceSummary expectedSummary = new InvoiceSummary(rides[2].length, 165.0);
        Assert.assertEquals(expectedSummary, summary);
    }
}
