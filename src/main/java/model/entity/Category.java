package model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "category")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "showAllCategory",query = "SELECT c from category c"),
        @NamedQuery(name ="findCategoryById",query = "select c from category c where id=:id"),
        @NamedQuery(name ="findCategoryByName",query ="select c from category c where name=name")
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "category_name")
    private String name;
    @Column(nullable = false,name = "category_description")
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Brand> brand;



    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public List<Brand> getBrand() {
        return brand;
    }

    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
