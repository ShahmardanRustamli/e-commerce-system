package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Category;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class ICategoryRepository extends RepositoryConfig implements CategoryRepository {
    @Override
    public int saveCategory(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(category);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
        }
        return 1;
    }

    @Override
    public List<Category> showAllCategory() {
        TypedQuery showAll = getEntityManager().createNamedQuery("showAllCategory",Category.class);
        return showAll.getResultList();
    }

    @Override
    public Optional<Category> findCategoryById(long id) {
        return Optional.ofNullable(getEntityManager().find(Category.class,id));
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        TypedQuery findByName = getEntityManager().createNamedQuery("findCategoryByName", Category.class);
        return findByName.getResultList();
    }

    @Override
    public int updateCategory(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(category);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
           throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);

        }
        return 1;
    }

    @Override
    public void deleteCategory(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().remove(category);
            getEntityTransaction().commit();
        }catch (Exception e){
            throw new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY);
        }

    }
}
