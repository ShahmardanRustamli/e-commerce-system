package service.impl;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import repository.CartRepository;
import repository.ProductRepository;
import repository.UserRepository;
import repository.impl.IProductRepository;
import service.UserService;
import util.InputUtil;
import java.util.Optional;

public class IUserService implements UserService {
    private CartRepository c;
    private ProductRepository repository;
    private UserRepository userRepository;


    public IUserService(){
        this.repository = new IProductRepository();
    }
    @Override
    public void showsAllProducts() {
        System.out.println(repository.showAllProducts());
    }

    @Override
    public Cart addProductsToCart() {
        long id = InputUtil.getInstance().inputLong("Enter Id to add cart");
        long productId = InputUtil.getInstance().inputLong("Enter Product Id to delete:");
        User user = userRepository.findById(id);
        Optional<Product> product = repository.findProductsById(productId);
        if (user!=null && product!=null){
            Cart cart = user.getCart();
            if (cart==null){
                cart=new Cart();
                user.setCart(cart);
            }
            return cart;
        }
        return null;
    }

    @Override
    public Optional deleteProductsFromCart() {
        long id = InputUtil.getInstance().inputLong("Enter Id to delete cart:");
        long productId = InputUtil.getInstance().inputLong("Enter Product Id to delete:");
        User user = userRepository.findById(id);
        Optional<Product> product = repository.findProductsById(productId);
        if (user!=null && user.getCart()!=null && product!=null){
            Cart cart = user.getCart();
            cart.getProduct().remove(product);
        }
        return Optional.ofNullable(user);

    }

    @Override
    public void buyCartProducts() {

    }

    @Override
    public void increaseBalances() {

    }
}
