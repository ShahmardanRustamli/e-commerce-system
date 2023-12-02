package repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.User;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.UserRepository;

import static helper.UserHelper.fillUser;

public class IUserRepository extends RepositoryConfig implements UserRepository {
    @Override
    public void registerUser(User user) {
        user = fillUser();
       getEntityManager().persist(user);
    }

    @Override
    public boolean isEmailTaken(String email) {
        try{
            getEntityManager().createQuery("select u from _user u where u.email=:email", User.class)
                    .setParameter("email",email).getResultList();
            return true;
        }catch (Exception e){
            throw new GeneralException(ExceptionEnum.EMAIL_ALREADY_EXIST_EXCEPTION);
        }

    }
    @Override
    public User findById(long id) {
        TypedQuery query = getEntityManager().createNamedQuery("findUserById", User.class);
        return getEntityManager().find(User.class,id);
    }
}
