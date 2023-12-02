package model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@Embeddable
public class ProductDetails {
    private String color;
    private String weight;

    public ProductDetails(String color, String weight) {
        this.color = color;
        this.weight = weight;
    }

    public ProductDetails() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "color='" + color + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
