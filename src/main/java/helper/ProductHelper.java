package helper;
import model.entity.Brand;
import model.entity.Product;
import model.entity.ProductDetails;
import util.InputUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static helper.BrandHelper.fillBrand;

public class ProductHelper {
    public static Product fillProduct(){
        String name = InputUtil.getInstance().inputString("Enter The Name:");
        String desc = InputUtil.getInstance().inputString("Enter The Description:");
        BigDecimal price = InputUtil.InputDecimal("Enter The Price:");
        int count = InputUtil.getInstance().inputInt("Enter The Product Count:");
        String color = InputUtil.getInstance().inputString("Enter The Product Color:");
        String weight = InputUtil.getInstance().inputString("Enter The Product Weight:");
        Product product = Product.builder()
                .name(name)
                .description(desc)
                .price(price)
                .count(count)
                .comment(new ArrayList<>())
                .brand((List<Brand>) fillBrand())
                .productDetails(ProductDetails
                        .builder().color(color)
                        .weight(weight).build())
                .build();
        return product;
    }
}
