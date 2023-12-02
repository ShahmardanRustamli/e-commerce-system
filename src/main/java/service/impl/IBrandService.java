package service.impl;
import model.entity.Brand;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.BrandRepository;
import repository.impl.IBrandRepository;
import service.BrandService;
import util.InputUtil;
import static helper.BrandHelper.fillBrand;

public class IBrandService implements BrandService {

    private final BrandRepository repository;

    public IBrandService(){
        this.repository = new IBrandRepository();
    }
    @Override
    public void saveBrands() {
        Brand brand = fillBrand();
        repository.saveBrand(brand);
    }

    @Override
    public void showAllBrands() {
        System.out.println(repository.showAllBrand());
    }

    @Override
    public void findBrandsById() {
        long id = InputUtil.getInstance().inputLong("Enter Brand ID to Find:");
        System.out.println(repository.findBrandById(id));
    }

    @Override
    public void findBrandsByName() {
        String name = InputUtil.getInstance().inputString("Enter Brand Name TO Find:");
        System.out.println(repository.findBrandByName(name));
    }

    @Override
    public void updateBrands() {
        System.out.println(repository.showAllBrand());
        long id = InputUtil.getInstance().inputLong("Enter Brand ID to Delete:");
        Brand brand = repository.findBrandById(id).orElseThrow(() ->
                new GeneralException(ExceptionEnum.BRAND_NO_FOUND_EXCEPTION));
        String name = InputUtil.getInstance().inputString("Enter The Updated Brand Name:");
        String description = InputUtil.getInstance().inputString("Enter The Updated Brand Description:");
        brand.setName(name);
        brand.setDescription(description);
        repository.updateBrand(brand);
    }

    @Override
    public void deleteBrands() {
        System.out.println(repository.showAllBrand());
        long id = InputUtil.getInstance().inputLong("Enter Brand ID to Delete:");
        Brand brand = repository.findBrandById(id).orElseThrow(() ->
                new GeneralException(ExceptionEnum.BRAND_NO_FOUND_EXCEPTION));
        repository.deleteBrand(brand);
    }
}
