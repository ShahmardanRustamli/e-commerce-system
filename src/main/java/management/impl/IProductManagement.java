package management.impl;
import management.AdminManagement;
import management.ProductManagement;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import service.ProductService;
import service.impl.IProductService;
import static util.MenuUtil.productMenu;

public class IProductManagement implements ProductManagement {
    AdminManagement adminManagement = new IAdminManagement();
    ProductService productService = new IProductService();
    @Override
    public void productManage() {
        while (true){
            try {
                int option = productMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        productService.saveProducts();
                        break;
                    case 2:
                        productService.showsAllProducts();
                        break;
                    case 3:
                        productService.findProductsByIds();
                        break;
                    case 4:
                        productService.findProductByName();
                        break;
                    case 5:
                        productService.updateProduct();
                        break;
                    case 6:
                        productService.deleteProduct();
                        break;
                    case 7:
                        adminManagement.adminManage();
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            }catch (Exception e){
                throw new GeneralException(ExceptionEnum.INVALID_OPTION);
            }
        }
    }
}
