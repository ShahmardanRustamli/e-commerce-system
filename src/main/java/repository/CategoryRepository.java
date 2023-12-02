package repository;
import model.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    int saveCategory(Category category);
    List<Category> showAllCategory();
    Optional<Category> findCategoryById(long id);
    List<Category> findCategoryByName(String name);
    int updateCategory(Category category);
    void deleteCategory(Category category);
}
