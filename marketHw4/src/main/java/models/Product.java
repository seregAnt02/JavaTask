package models;

public class Product {
    private  String name;

    private  double price;

    private double discountAmount;
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
