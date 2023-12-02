package repository;
import model.entity.User;

public interface UserRepository {
    void registerUser(User user);
    boolean isEmailTaken(String username);
    User findById(long id);
}
