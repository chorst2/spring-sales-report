package edu.wctc;

import java.text.DecimalFormat;
import java.util.List;

public class DetailedReport implements SalesReport{
    @Override
    public void generateReport(List<Sale> salesList) {

        System.out.println("Sales Detail Report:");
        System.out.printf("%-20s%-20s%-10s%-10s%-10s\n", "Customer", "Country", "Amount", "Tax", "Shipping");

        for(Sale sale : salesList){
            System.out.printf("%-20s%-20s%-10.2f%-10.2f%-10.2f\n", sale.getCustomer(), sale.getCountry(),
                    sale.getAmount(), sale.getTax(), sale.getShipping());
        }
    }
}
