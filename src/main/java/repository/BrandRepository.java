package repository;
import model.entity.Brand;
import java.util.List;
import java.util.Optional;

public interface BrandRepository {
    int saveBrand(Brand brand);
    List<Brand> showAllBrand();
    Optional<Brand> findBrandById(long id);
    List<Brand> findBrandByName(String name);
    int updateBrand(Brand brand);
    void deleteBrand(Brand brand);
}
