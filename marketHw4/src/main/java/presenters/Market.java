package presenters;

import exception.ProductNotFoundException;
import exception.QuantityIsNegativeException;
import exception.UserNotFoundException;
import models.Order;
import models.Product;
import models.User;
import views.ViewMarket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;

public class Market {

    private List<User> users;
    private List<Product> productsMarket;
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

    enum DataTypeFile {
        Customer("customers.txt"), Order("orders.txt"), Product("products.txt");

        private String fileName;
        DataTypeFile(String fileName){
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }
    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProductsMarket() {
        return productsMarket;
    }
    public Market() {

          users = new ArrayList<>(List.of(
                new User("Иван", 45, "111", User.Genus.Male.getType()),
                new User("Петр", 41, "222", User.Genus.Male.getType()),
                new User("Маша", 30, "333", User.Genus.Female.getType())
        ));

        productsMarket = new ArrayList<>(List.of(
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
        Order order = new Order(user, viewMarket);
        orders.add(order);
        return order.getId();
    }
    // добавление продукта в ордер закаказа.
    public Order addProductToOrder(int orderId, User user, Product product, int quantity)
        throws ProductNotFoundException, QuantityIsNegativeException
    {
        if(!productsMarket.contains(product)) throw new ProductNotFoundException("product not found.");
        if(quantity <= 0) throw new QuantityIsNegativeException("quantity of product is negative");
        Order order = orders.stream().filter(f -> f.getId() == orderId).findFirst().get();
        // Расчет скидки.
        product.setDiscountAmount(discount(user, product.getPrice(), user.getGenus()));
        order.addProduct(product, quantity);
        return  order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Скидка с заказа.
    double discount(User user, double price, String genus){

        int percent = 0; double totalSum = 0;

        if(User.Genus.Male.getType().equals(genus) &&
                Holiday.MaleDay.getDay().equals(LocalDate.now())){
            percent = 15;
            totalSum = discountSum(price, percent);
            viewMarket.HolidayMale(user, totalSum);
            viewMarket.Discount(user, percent);
            return  totalSum;
        }
        if(User.Genus.Female.getType().equals(genus) &&
                Holiday.WomenDay.getDay().equals(LocalDate.now())){
            percent = 15;
            totalSum = discountSum(price, percent);
            viewMarket.HolidayFemale(user, totalSum);
            viewMarket.Discount(user, percent);
            return  totalSum;
        }
        if(Holiday.NewYear.getDay().equals(LocalDate.now())){
            percent = 20;
            totalSum = discountSum(price, percent);
            viewMarket.HolidayNewYear(user, totalSum);
            viewMarket.Discount(user, percent);
            return totalSum;
        }
        if(Holiday.NoHoliday.getDay().equals(LocalDate.now())){
            viewMarket.Holiday(user);
        }
        return totalSum;
    }


    // скидка
    private double discountSum(double price, int percent){
        double totalSum = price - price * percent / 100;
        return  totalSum;
    }

    public void writeFileData(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < orders.size(); i++) {
                if (fileName == DataTypeFile.Order.getFileName()) {
                    sb.append(orders.get(i).toString() + "\r\n");
                }
                if (fileName == DataTypeFile.Customer.getFileName()) {
                    sb.append(orders.get(i).getUser().toString() + "\r\n");
                }
                if (fileName == DataTypeFile.Product.getFileName()) {
                    for (Map.Entry<Product, Integer> productIntegerEntry : orders.get(i).getProducts().entrySet()) {
                        sb.append(productIntegerEntry.getKey() + ":" + productIntegerEntry.getValue() + "\r\n");
                    }
                }
            }
            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            viewMarket.WriteData(fileName, sb.toString());
            fos.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
