package repository;
import jakarta.transaction.Transactional;
import model.entity.Cart;
import model.entity.User;
import java.util.List;

public interface CartRepository {
    List<Cart> findAllByUser(User user);
    @Transactional
    Cart save(Cart cart);
    @Transactional
    void delete(Cart cart);
}
