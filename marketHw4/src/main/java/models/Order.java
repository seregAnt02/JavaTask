package models;

import presenters.Market;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public class Order {

    private Integer id;
    private  User user;
    private Map<Product, Integer> products;

    private LocalDate holiday;
    private int count;
    public Order(User user) {
        this.id = ++count;
        this.user = user;
        products = new HashMap<Product, Integer>();
        this.holiday = Market.Holiday.NoHoliday.getDay();
    }

    public Integer getId() {
        return id;
    }

    public  void addProduct(Product product, int quantity){
        products.put(product, quantity);
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", holiday='" + holiday + '\'' +
                ", count=" + count +
                '}';
    }
}
