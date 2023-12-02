package model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity(name = "_user")
@Builder
@NamedQuery(name = "findUserById",query = "select u from _user u where id=id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "user_name")
    private String name;
    @Column(nullable = false,name = "user_surname")
    private String surname;
    @Column(nullable = false,name = "user_birthdate")
    private LocalDate birthDate;
    @Column(unique = true, nullable = false,name = "user_fin_num")
    private String finNumber;
    @Column(nullable = false,name = "user_balance")
    private BigDecimal balance;
    @Column(unique = true,nullable = false,name = "user_email")
    private String email;
    @Column(nullable = false,name = "user_password")
    private String password;
    @Column(nullable = false,name = "user_address")
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public User() {
    }

    public User(Long id, String name, String surname, LocalDate birthDate, String finNumber, BigDecimal balance, String email, String password, String address,Cart cart) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        setBirthday(birthDate);
        setFinNumber(finNumber);
        this.balance = balance;
        this.email = email;
        setPassword(password);
        this.address = address;
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setBirthday(LocalDate birthday) {
        int birthDate = birthday.getYear();
        int nowDate = LocalDate.now().getYear();
        boolean success = (nowDate - birthDate) >= 18;
        if (success) this.birthDate = birthday;
        else throw new GeneralException(ExceptionEnum.UNDER_AGE_EXCEPTION);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.toUpperCase();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFinNumber() {
        return finNumber;
    }

    public void setFinNumber(String finNumber) {
        if (finNumber.length()==7)this.finNumber=finNumber.toUpperCase();
        else {
            throw new GeneralException(ExceptionEnum.INVALID_FIN_EXCEPTION);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.toUpperCase();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length()<8 ){
            throw new GeneralException(ExceptionEnum.INVALID_LOGIN_EXCEPTION);
        }else{
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", finNumber='" + finNumber + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", cart=" + cart +
                '}';
    }
}

