package management.impl;
import management.Management;
import management.UserManagement;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import service.UserService;
import service.impl.IUserService;
import static util.MenuUtil.userMenu;

public class IUserManagement implements UserManagement {
    UserService userService = new IUserService();
//    Management management = new IManagement();
    @Override
    public void userManagement() {
        while (true){
            try {
                int option = userMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        userService.showsAllProducts();
                        break;
                    case 2:
                        userService.addProductsToCart();
                        break;
                    case 3:
                        userService.deleteProductsFromCart();
                        break;
                    case 4:
                        userService.buyCartProducts();
                        break;
                    case 5:
                        userService.increaseBalances();
                        break;
                    case 6:
//                        management.manage();
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
