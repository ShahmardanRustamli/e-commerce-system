package management.impl;
import management.AdminManagement;
import management.BrandManagement;
import management.CategoryManagement;
import management.ProductManagement;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import static util.MenuUtil.adminMenu;

public class IAdminManagement implements AdminManagement {
    BrandManagement brandManagement = new IBrandManagement();
    ProductManagement productManagement = new IProductManagement();
    CategoryManagement categoryManagement = new ICategoryManagement();
    @Override
    public void adminManage() {
        while (true){
            try {
                int option = adminMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        categoryManagement.categoryManage();
                        break;
                    case 2:
                        brandManagement.brandManage();
                        break;
                    case 3:
                        productManagement.productManage();
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
