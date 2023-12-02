package repository.impl;
import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Product;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.ProductRepository;
import java.util.List;
import java.util.Optional;

public class IProductRepository extends RepositoryConfig implements ProductRepository {
    @Override
    public Product saveProduct(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(product);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.PERSIST_UNSUCCESSFULLY);
        }
        return product;
    }

    @Override
    public List<Product> showAllProducts() {
        TypedQuery<Product> showAll = getEntityManager().createNamedQuery("showAllProducts", Product.class);
        return showAll.getResultList();
    }

    @Override
    public Optional<Product> findProductsById(long id) {
        TypedQuery<Product> findById = getEntityManager().createNamedQuery("findProductById", Product.class);
        findById.setParameter("id",id);
        Product result = findById.getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public List<Product> findProductByName(String name) {
        TypedQuery findByName= getEntityManager().createNamedQuery("findProductByName",Product.class);
        findByName.setParameter("name",name);
        return findByName.getResultList();
    }

    @Override
    public int updateProduct(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(product);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);
        }
        return 1;
    }

    @Override
    public void deleteProduct(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().remove(product);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY);
        }
    }
}
