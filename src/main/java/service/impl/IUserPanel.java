package service.impl;
import model.config.RepositoryConfig;
import model.entity.User;
import service.UserPanel;
import util.InputUtil;
import static helper.UserHelper.fillUser;

public class IUserPanel extends RepositoryConfig implements UserPanel {
    @Override
    public boolean login() {
        String email = InputUtil.getInstance().inputString("Enter The e-mail:");
        String password = InputUtil.getInstance().inputString("Enter The Password:");
        return false;
    }

    @Override
    public boolean signUp() {
        User user = fillUser();
        if (user!=null){
        }
        return false;
    }
}
