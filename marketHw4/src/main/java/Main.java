import exception.ProductNotFoundException;
import exception.QuantityIsNegativeException;
import exception.UserNotFoundException;
import models.Order;
import models.User;
import presenters.Market;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Market market = new Market();
        List<User> users = market.getUsers();
        int orderId_0 = 0, orderId_1 = 0;
        try {
            orderId_0 = market.createOrder(users.get(0));
            orderId_1 = market.createOrder(users.get(2));
            market.addProductToOrder(orderId_0, users.get(0), market.getProductsMarket().get(0), 5);
            market.addProductToOrder(orderId_1, users.get(2), market.getProductsMarket().get(1), 10);
            market.writeFileData("customers.txt");
            market.writeFileData("orders.txt");
            market.writeFileData("products.txt");

            //System.out.print(market.getOrders());
        }
        catch (UserNotFoundException | ProductNotFoundException | QuantityIsNegativeException e){
            System.out.print(e.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
