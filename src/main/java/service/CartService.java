package service;

import model.entity.Cart;
import model.entity.User;

import java.util.List;

public interface CartService {

    List<Cart> getCartsItemsByUser(User user);

    void addToCarts(long id, long productId);
    void removeFromCarts(Cart cart);
}
