package service.impl;
import model.constants.Constant;
import model.entity.Product;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.ProductRepository;
import repository.impl.IProductRepository;
import service.ProductService;
import util.InputUtil;
import java.math.BigDecimal;
import static helper.ProductHelper.fillProduct;

public class IProductService implements ProductService {

    private final ProductRepository repository;

    public IProductService(){
        this.repository = new IProductRepository();
    }
    @Override
    public void saveProducts() {
        Product product = fillProduct();
        repository.saveProduct(product);
        System.out.println(Constant.SAVE_SUCCESSFULLY);
    }

    @Override
    public void showsAllProducts() {
        System.out.println(repository.showAllProducts());
    }

    @Override
    public void findProductsByIds() {
        long id = InputUtil.getInstance().inputLong("Enter Product ID to Find:");
        System.out.println(repository.findProductsById(id));
    }

    @Override
    public void findProductByName() {
        String name = InputUtil.getInstance().inputString("Enter Product Name To Find:");
        System.out.println(repository.findProductByName(name));
    }

    @Override
    public void updateProduct() {
        System.out.println(repository.showAllProducts());
        long id = InputUtil.getInstance().inputLong("Enter Product ID to Update:");
        Product product = repository.findProductsById(id).
                orElseThrow(() -> new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY));
        String name = InputUtil.getInstance().inputString("Enter The Updated Product Name:");
        String desc = InputUtil.getInstance().inputString("Enter The Updated Product Description:");
        BigDecimal price = InputUtil.InputDecimal("Enter The Updated Product Price:");
        product.setName(name);
        product.setDescription(desc);
        product.setPrice(price);
        repository.updateProduct(product);

    }

    @Override
    public void deleteProduct() {
        System.out.println(repository.showAllProducts());
        long id = InputUtil.getInstance().inputLong("Enter Product ID to Delete:");
        Product product = repository.findProductsById(id)
                .orElseThrow(() -> new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY));
        repository.deleteProduct(product);
    }
}
