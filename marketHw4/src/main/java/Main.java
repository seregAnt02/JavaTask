import exception.ProductNotFoundException;
import exception.QuantityIsNegativeException;
import exception.UserNotFoundException;
import models.Order;
import models.User;
import presenters.Market;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Market market = new Market();
        List<User> users = market.getUsers();
        int orderId = 0;
        try {
            orderId = market.createOrder(users.get(0));
            Order order = market.addProductToOrder(orderId, market.getProducts().get(0), 5);
            market.bye(market.getProducts().get(0).getPrice(), User.Genus.Male.getType());

            System.out.print(market.getOrders());
        }
        catch (UserNotFoundException | ProductNotFoundException | QuantityIsNegativeException e){
            System.out.print(e.getMessage());
        }
    }
}
