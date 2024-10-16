package org.example;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        double discount = calculateDiscount(product);

        if (nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }

        return discount;
    }

    @Override
    public String getDescription(Product product) {
        String description = getSpecificDescription();
        if (nextDiscount != null) {
            description += ", " + nextDiscount.getDescription(product);
        }
        return description;
    }

    protected abstract String getSpecificDescription();

    protected abstract double calculateDiscount(Product product);
}
