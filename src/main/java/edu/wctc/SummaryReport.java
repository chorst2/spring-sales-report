package edu.wctc;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryReport implements SalesReport{
    @Override
    public void generateReport(List<Sale> salesList) {
        Map<String, Sale> byCountry = new HashMap<>();


        for (Sale sale : salesList) {
            if (!byCountry.containsKey(sale.getCountry())) {
                byCountry.put(sale.getCountry(), new Sale(sale.getCountry()));
            }
            Sale totalSum = byCountry.get(sale.getCountry());
            totalSum.setAmount(totalSum.getAmount() + sale.getAmount());
            totalSum.setTax(totalSum.getTax() + sale.getTax());
            totalSum.setShipping(totalSum.getShipping() + sale.getShipping());
        }

        System.out.println("Sales Summary Report:");
        System.out.printf("%-20s%-10s%-10s%-10s\n", "Country", "Amount", "Tax", "Shipping");

        for(Sale sale : byCountry.values()){
            System.out.printf("%-20s%-10.2f%-10.2f%-10.2f\n", sale.getCountry(), sale.getAmount(), sale.getTax(), sale.getShipping());

        }
    }
}
