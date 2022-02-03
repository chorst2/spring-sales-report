package edu.wctc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesReportHelper {
    @Autowired
    private SalesInput salesInput;
    @Autowired
    private SalesReport salesReport;
    @Autowired
    private ShippingPolicy shippingPolicy;

    public void generateReport(){
        List<Sale> allSales = salesInput.getSales();
        for(Sale aSale : allSales)
            shippingPolicy.applyShipping(aSale);
        salesReport.generateReport(allSales);
    }


}
