package edu.wctc;

public class FlatRateShippingPolicy implements ShippingPolicy{
    @Override
    public void applyShipping(Sale sale) {
        //10% shipping to the total cost (total of amount + tax)
        double shippingAmount;
        double shippingRate = .1;

        //get the amount and tax from the sale
        double saleAmount = sale.getAmount();
        double saleTax = sale.getTax();

        //calculate the shipping amount
        shippingAmount = (saleAmount+saleTax)*shippingRate;

        //set the shipping for the sale to the calculated amount
        sale.setShipping(shippingAmount);
    }
}
