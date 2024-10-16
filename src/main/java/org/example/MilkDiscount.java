package org.example;

public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected double calculateDiscount(Product product) {
        if (product.name().equalsIgnoreCase("milk")) {
            return product.price() * 0.05 * product.quantity();
        }
        return 0;
    }

    @Override
    protected String getSpecificDescription() {
        return "5% off on milk";
    }
}
