package model.entity;
import jakarta.persistence.*;
import lombok.Builder;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "products")
@Builder
@NamedQueries({
        @NamedQuery(name = "findProductById",query = "select p from products p where count>0 and id=:id"),
        @NamedQuery(name = "findProductByName",query = "select p from products p where name=name"),
        @NamedQuery(name = "showAllProducts",query = "select p from products p where count>0"),
})

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "product_name")
    private String name;
    @Column(nullable = false,name = "product_description")
    private String description;
    @Column(nullable = false,name = "product_price")
    private BigDecimal price;
    @Column(nullable = false,name = "product_comments")
    @ElementCollection
    private List<String> comment;
    @Column(nullable = false,name = "product_count")
    private int count;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Brand> brand;

    @ManyToOne(cascade = CascadeType.ALL)

    private Category category;

    @Embedded
    private ProductDetails productDetails;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, List<String> comment, int count, List<Brand> brand, Category category, ProductDetails productDetails) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.comment = comment;
        this.count = count;
        this.brand = brand;
        this.category = category;
        this.productDetails = productDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Brand> getBrand() {
        return brand;
    }

    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }
}
