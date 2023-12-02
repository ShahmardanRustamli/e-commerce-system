package management.impl;
import management.AdminManagement;
import management.CategoryManagement;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import service.CategoryService;
import service.impl.ICategoryService;
import static util.MenuUtil.categoryMenu;

public class ICategoryManagement implements CategoryManagement {
    AdminManagement adminManagement = new IAdminManagement();
    CategoryService categoryService = new ICategoryService();
    @Override
    public void categoryManage() {
        while (true){
            try {
                int option = categoryMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        categoryService.saveCategories();
                        break;
                    case 2:
                        categoryService.showAllCategories();
                        break;
                    case 3:
                        categoryService.findCategoriesById();
                        break;
                    case 4:
                        categoryService.findCategoriesByName();
                        break;
                    case 5:
                        categoryService.updateCategories();
                        break;
                    case 6:
                        categoryService.deleteCategories();
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
