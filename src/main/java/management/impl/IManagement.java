package management.impl;
import management.Management;
import management.UserManagement;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import static helper.AdminHelper.adminEntry;
import static util.MenuUtil.entryMenu;

public final class IManagement implements Management {
    UserManagement userManagement = new IUserManagement();
    @Override
    public void manage() {
        while (true){
            try {
                byte option = entryMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        adminEntry();
                        break;
                    case 2:
                        userManagement.userManagement();
                        break;
                    default:
                        new GeneralException(ExceptionEnum.INVALID_OPTION);
                }
            }catch (Exception e){
                throw new GeneralException(ExceptionEnum.INVALID_OPTION);
            }
        }
    }
}
