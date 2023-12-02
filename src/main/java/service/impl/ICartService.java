package service.impl;
import jakarta.persistence.EntityManager;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import repository.CartRepository;
import repository.ProductRepository;
import repository.UserRepository;
import service.CartService;
import java.util.List;
import java.util.Optional;

public class ICartService implements CartService {

    EntityManager entityManager;
    ProductRepository productRepository;
    private CartRepository repository;
    private UserRepository userRepository;

    public void CartService(CartRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Cart> getCartsItemsByUser(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public void addToCarts(long id, long productId) {
        User user = userRepository.findById(id);
        Optional<Product> product = productRepository.findProductsById(productId);
        if (user!= null && product!=null){
            Cart cart = user.getCart();
            if (cart ==null){
                cart=new Cart();
                user.setCart(cart);
            }
        }
    }

    @Override public void removeFromCarts(Cart cart) {
        repository.delete(cart);
    }
}
