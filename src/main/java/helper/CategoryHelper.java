package helper;
import model.entity.Category;
import util.InputUtil;
public class CategoryHelper {
    public static Category fillCategory(){
        String name = InputUtil.getInstance().inputString("Enter The Category Name:");
        String desc = InputUtil.getInstance().inputString("Enter The Category Name:");
        Category category = Category.builder()
                .name(name)
                .description(desc)
                .build();
        return category;

    }
}
