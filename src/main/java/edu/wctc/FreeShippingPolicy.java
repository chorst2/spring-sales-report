package edu.wctc;

public class FreeShippingPolicy implements ShippingPolicy{
    @Override
    public void applyShipping(Sale sale) {
        //free shipping regardless
        sale.setShipping(0.00);
    }
}
