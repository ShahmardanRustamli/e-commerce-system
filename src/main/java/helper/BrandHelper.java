package helper;
import model.entity.Brand;
import model.entity.Product;
import util.InputUtil;
import java.util.List;
import static helper.ProductHelper.fillProduct;

public class BrandHelper {
    public static Brand fillBrand(){
        String name = InputUtil.getInstance().inputString("Enter The Brand Name:");
        String desc = InputUtil.getInstance().inputString("Enter The Brand Description:");
        Brand brand = Brand.builder()
                .name(name)
                .description(desc)
                .products((List<Product>) fillProduct())
                .build();
        return brand;
    }
}
