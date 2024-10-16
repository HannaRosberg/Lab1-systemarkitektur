package org.example;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("milk", 20.0, 3);
        Product bread = new Product("bread", 25.0, 5);

        Discount fridayDiscount = new FridayDiscount(null);
        Discount milkDiscount = new MilkDiscount(fridayDiscount);
        Discount quantityDiscount = new QuantityDiscount(milkDiscount);

        double milkOriginalPrice = milk.price() * milk.quantity();
        double milkDiscountValue = quantityDiscount.apply(milk);
        double milkTotalPrice = milkOriginalPrice - milkDiscountValue;

        System.out.println("Milk original price: " + milkOriginalPrice + " SEK");
        System.out.println("Milk discount: " + milkDiscountValue + " SEK");
        System.out.println("Milk total price after discount: " + milkTotalPrice + " SEK");
        System.out.println("Milk discount description: " + quantityDiscount.getDescription(milk));

        System.out.println();

        double breadOriginalPrice = bread.price() * bread.quantity();
        double breadDiscountValue = quantityDiscount.apply(bread);
        double breadTotalPrice = breadOriginalPrice - breadDiscountValue;

        System.out.println("Bread original price: " + breadOriginalPrice + " SEK");
        System.out.println("Bread discount: " + breadDiscountValue + " SEK");
        System.out.println("Bread total price after discount: " + breadTotalPrice + " SEK");
        System.out.println("Bread discount description: " + quantityDiscount.getDescription(bread));
    }
}
