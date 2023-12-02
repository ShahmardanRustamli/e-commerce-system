package service;
import model.entity.Cart;
import java.util.Optional;

public interface UserService {
    void showsAllProducts();
    Cart addProductsToCart();
    Optional deleteProductsFromCart();
    void buyCartProducts();
    void increaseBalances();

}
