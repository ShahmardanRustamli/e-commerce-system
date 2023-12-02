package helper;
import model.entity.User;
import util.InputUtil;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UserHelper {

    public static User fillUser(){
        String name = InputUtil.getInstance().inputString("Enter The Name:");
        String surname = InputUtil.getInstance().inputString("Enter The Surname:");
        LocalDate birthDay = dateFormat("Enter The Birthdate:");
        String finNum = InputUtil.getInstance().inputString("Enter The Fin Number:");
        BigDecimal balance = BigDecimal.valueOf(5000);
        String email = InputUtil.getInstance().inputString("Enter The E-mail:");
        String pass = InputUtil.getInstance().inputString("Enter The Password:");
        String address = InputUtil.getInstance().inputString("Enter The Address:");
        User user = User.builder()
                .name(name)
                .surname(surname)
                .birthDate(birthDay)
                .finNumber(finNum)
                .balance(balance)
                .email(email)
                .password(pass)
                .address(address)
                .build();
        return user;
    }


    private static LocalDate dateFormat(String s) {
        String stringDate = InputUtil.getInstance().inputString(s + " - (FORMAT ONLY: yyyy/MM/dd): ");
        String[] splitDate = stringDate.split("/");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        return LocalDate.of(year, month, day);
    }
}
