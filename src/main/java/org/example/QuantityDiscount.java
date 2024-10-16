package org.example;

public class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected double calculateDiscount(Product product) {
        if (product.quantity() >= 5) {
            return 10.0 * product.quantity();
        }
        return 0;
    }

    @Override
    protected String getSpecificDescription() {
        return "10 SEK off per product for 5 or more items";
    }
}
