package presenters;

import exception.ProductNotFoundException;
import exception.QuantityIsNegativeException;
import exception.UserNotFoundException;
import models.Order;
import models.Product;
import models.User;
import views.ViewMarket;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Market {

    private List<User> users;
    private List<Product> products;
    private List<Order> orders;

    private ViewMarket viewMarket;
    public enum Holiday{
        NoHoliday(LocalDate.now()),
        WomenDay(LocalDate.of(2024, 03, 8)),
        MaleDay(LocalDate.of(2024, 02, 23)),
        NewYear(LocalDate.of(2024, 12, 31));

        private LocalDate day;

        public LocalDate getDay() {
            return day;
        }

        Holiday(LocalDate day) {
            this.day = day;
        }
    }
    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }
    public Market() {

          users = new ArrayList<>(List.of(
                new User("Иван", 45, "111", User.Genus.Male),
                new User("Петр", 41, "222", User.Genus.Male),
                new User("Маша", 30, "333", User.Genus.Female)
        ));

        products = new ArrayList<>(List.of(
               new Product("Milk", 60),
               new Product("bread", 40),
               new Product("tea", 200)
        ));

        orders = new ArrayList<>();

        viewMarket = new ViewMarket();

    }

    // создание ордера.
    public int createOrder(User user) throws UserNotFoundException {
        if(!users.contains(user)) throw new UserNotFoundException("user not found" + user);
        Order order = new Order(user);
        orders.add(order);
        return order.getId();
    }
    // добавление продукта в ордер закаказа.
    public Order addProductToOrder(int orderId, Product product, int quantity)
        throws ProductNotFoundException, QuantityIsNegativeException
    {
        if(!products.contains(product)) throw new ProductNotFoundException("product not found.");
        if(quantity <= 0) throw new QuantityIsNegativeException("quantity of product is negative");
        Order order = orders.stream().filter(f -> f.getId() == orderId).findFirst().get();
        order.addProduct(product, quantity);
        return  order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // создании заказа.
    public void bye(double price, String genus){

        int percent = 0;
        if(Holiday.NoHoliday.getDay().equals(LocalDate.now())){
            viewMarket.viewHoliday();
        }
        if(User.Genus.Male.getType().equals(genus) &&
                Holiday.MaleDay.getDay().equals(LocalDate.now())){
            percent = 15;
            double totalSum = discount(price, percent);
            viewMarket.viewHolidayMale(totalSum);
            viewMarket.viewDiscount(percent);
        }
        if(User.Genus.Female.getType().equals(genus) &&
                Holiday.WomenDay.getDay().equals(LocalDate.now())){
            percent = 15;
            double totalSum = discount(price, percent);
            viewMarket.viewHolidayFemale(totalSum);
            viewMarket.viewDiscount(percent);
        }
        if(Holiday.NewYear.getDay().equals(LocalDate.now())){
            percent = 20;
            double totalSum = discount(price, percent);
            viewMarket.viewHolidayNewYear(totalSum);
            viewMarket.viewDiscount(percent);
        }
    }


    // скидка
    private double discount(double price, int percent){
        double totalSum = price * percent / 100 + price;
        return  totalSum;
    }

}
