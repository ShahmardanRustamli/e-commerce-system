package model.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity(name = "brands")
@Builder

@NamedQueries({
        @NamedQuery(name = "findBrandById",query = "select b from brands b where id=:id"),
        @NamedQuery(name = "findBrandByName",query = "select b from brands b where name=name"),
        @NamedQuery(name = "showAllBrand",query = "select b from brands b"),
})
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "brand_name")
    private String name;
    @Column(name = "brand_description")
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Product> products;

    public Brand() {
    }

    public Brand(Long id, String name, String description, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
