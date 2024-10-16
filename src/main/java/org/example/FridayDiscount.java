package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected double calculateDiscount(Product product) {
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            return product.price() * 0.10 * product.quantity();
        }
        return 0;
    }

    @Override
    protected String getSpecificDescription() {
        return "10% off on Fridays";
    }
}
