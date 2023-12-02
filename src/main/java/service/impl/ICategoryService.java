package service.impl;
import model.constants.Constant;
import model.entity.Category;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.CategoryRepository;
import repository.impl.ICategoryRepository;
import service.CategoryService;
import util.InputUtil;

import static helper.CategoryHelper.fillCategory;

public class ICategoryService implements CategoryService {

    private final CategoryRepository repository;

    public ICategoryService(){
        this.repository = new ICategoryRepository();
    }
    @Override
    public void saveCategories() {
        Category category = fillCategory();
        repository.saveCategory(category);
        System.out.println(Constant.SAVE_SUCCESSFULLY);
    }

    @Override
    public void showAllCategories() {
        System.out.println(repository.showAllCategory());
    }

    @Override
    public void findCategoriesById() {
        long id = InputUtil.getInstance().inputLong("Enter Category ID to Find:");
        System.out.println(repository.findCategoryById(id));
    }

    @Override
    public void findCategoriesByName() {
        String name = InputUtil.getInstance().inputString("Enter The Category Name to Find:");
        System.out.println(repository.findCategoryByName(name));
    }

    @Override
    public void updateCategories() {
        System.out.println(repository.showAllCategory());
        long id = InputUtil.getInstance().inputLong("Enter Category ID to Update:");
        Category category = repository.findCategoryById(id)
                .orElseThrow(() -> new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY));
        String name = InputUtil.getInstance().inputString("Enter The Updated Category Name:");
        String desc = InputUtil.getInstance().inputString("Enter The Updated Category Description:");
        category.setName(name);
        category.setDescription(desc);
        repository.updateCategory(category);
    }

    @Override
    public void deleteCategories() {
        System.out.println(repository.showAllCategory());
        long id = InputUtil.getInstance().inputLong("Enter ID to Delete Category:");
        Category category = repository.findCategoryById(id)
                .orElseThrow(() -> new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY));
        repository.deleteCategory(category);
    }
}
