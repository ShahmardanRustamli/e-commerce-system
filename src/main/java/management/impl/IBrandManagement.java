package management.impl;
import management.AdminManagement;
import management.BrandManagement;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import service.BrandService;
import service.impl.IBrandService;
import static util.MenuUtil.brandMenu;

public class IBrandManagement implements BrandManagement {
    AdminManagement adminManagement = new IAdminManagement();
    BrandService brandService = new IBrandService();
    @Override
    public void brandManage() {
        while (true){
            try {
                int option = brandMenu();
                switch (option){
                    case 0:
                   System.exit(-1);
                    case 1:
                        brandService.saveBrands();
                        break;
                    case 2:
                        brandService.showAllBrands();
                        break;
                    case 3:
                        brandService.findBrandsById();
                        break;
                    case 4:
                        brandService.findBrandsByName();
                        break;
                    case 5:
                        brandService.updateBrands();
                        break;
                    case 6:
                        brandService.deleteBrands();
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
