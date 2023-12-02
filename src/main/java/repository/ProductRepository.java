package repository;
import model.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product saveProduct(Product product);
    List<Product> showAllProducts();
    Optional<Product> findProductsById(long id);
    List<Product> findProductByName(String name);
    int updateProduct(Product product);
    void deleteProduct(Product product);
}
