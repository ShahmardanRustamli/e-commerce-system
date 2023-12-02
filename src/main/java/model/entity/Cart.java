package model.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "cart")
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(nullable = false,name = "cart_count")
    private Long count;
    @Column(nullable = false,name = "cart_amount")
    private BigDecimal totalAmount;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    public Cart() {
    }

    public Cart(Long id, Product product, Long count, BigDecimal totalAmount, User user) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.totalAmount = totalAmount;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProduct() {
        return (List<Product>) product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
