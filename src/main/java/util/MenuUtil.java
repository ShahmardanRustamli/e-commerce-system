package util;

public class MenuUtil {
    public static byte entryMenu() {
        System.out.println("[0 -> Exit]\n" +
                "[1] -> Admin\n" +
                "[2] -> Customer");
        return InputUtil.getInstance().inputByte("Choose Option:");
    }
    public static int adminMenu(){
        System.out.println("[0 -> Exit]\n" +
                "[0] -> Back\n" +
                "[2] -> Category\n" +
                "[3] -> Brand\n" +
                "[4] -> Product\n");
        return InputUtil.getInstance().inputInt("Choose Option:");
    }
    public static int categoryMenu(){
        System.out.println("[0] > Exit\n" +
                "[1] -> Save Category\n" +
                "[2] -> Show All Category\n" +
                "[3] -> Find By ID:\n" +
                "[4] -> Find By Name:\n" +
                "[5] -> Update Category\n" +
                "[6] -> Delete Category\n" +
                "[7] - Back");
        return InputUtil.getInstance().inputInt("Choose Option:");
    }
    public static int brandMenu(){
        System.out.println("[0] > Exit\n" +
                "[1] -> Save Brand\n" +
                "[2] -> Show All Brand\n" +
                "[3] -> Find By ID:\n" +
                "[4] -> Find By Name:\n" +
                "[5] -> Update Brand\n" +
                "[6] -> Delete Brand\n" +
                "[7] - Back");
        return InputUtil.getInstance().inputInt("Choose Option:");
    }
    public static int productMenu(){
        System.out.println("[0] > Exit\n" +
                "[1] -> Save Brand\n" +
                "[2] -> Show All Products\n" +
                "[3] -> Find By ID:\n" +
                "[4] -> Find By Name:\n" +
                "[5] -> Update Product\n" +
                "[6] -> Delete Product\n" +
                "[7] - Back");
        return InputUtil.getInstance().inputInt("Choose Option:");
    }
    public static int userMenu(){
        System.out.println("[0] > Exit\n" +
                "[1] -> Show All Product\n" +
                "[2] -> Add Product To Cart\n" +
                "[3] -> Delete Product From Cart\n" +
                "[4] -> Buy Products\n" +
                "[5] -> Increase Balance\n" +
                "[6] - Back");
        return InputUtil.getInstance().inputInt("Choose Option:");
    }
}
