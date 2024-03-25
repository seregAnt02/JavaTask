package models;

import presenters.Market;
import views.ViewMarket;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public class Order {

    private Integer id;
    private  User user;
    private Map<Product, Integer> products;

    private LocalDate holiday;
    private static int count;

    private ViewMarket viewMarket;
    public Order(User user, ViewMarket viewMarket){
        this.id = ++count;
        this.user = user;
        products = new HashMap<Product, Integer>();
        this.holiday = Market.Holiday.NoHoliday.getDay();
        this.viewMarket = viewMarket;
    }

    public Integer getId() {
        return id;
    }

    public  void addProduct(Product product, int quantity){
        products.put(product, quantity);
        viewMarket.AddProduct(product);
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products.txt=" + products +
                ", holiday='" + holiday + '\'' +
                ", count=" + count +
                '}';
    }
}
