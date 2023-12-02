package repository.impl;
import model.config.RepositoryConfig;
import model.entity.Cart;
import model.entity.User;
import repository.CartRepository;
import java.util.List;

public class ICartRepository extends RepositoryConfig implements CartRepository {
    @Override
    public List<Cart> findAllByUser(User user) {
        return getEntityManager().createQuery("select cart from cart where cart.user=:user", Cart.class)
                .setParameter("user",user).getResultList();
    }

    @Override
    public Cart save(Cart cart) {
        getEntityManager().persist(cart);
        return cart;
    }

    @Override
    public void delete(Cart cart) {
        getEntityManager().remove(getEntityManager()
                .contains(cart) ? cart : getEntityManager().merge(cart));
    }
}
