package repository.impl;
import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Brand;
import model.enums.ExceptionEnum;
import model.exceptions.GeneralException;
import repository.BrandRepository;
import java.util.List;
import java.util.Optional;

public class IBrandRepository extends RepositoryConfig implements BrandRepository {
    @Override
    public int saveBrand(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(brand);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.PERSIST_UNSUCCESSFULLY);
        }
        return 1;
    }

    @Override
    public List<Brand> showAllBrand() {
        TypedQuery<Brand> showAll = getEntityManager().createNamedQuery("showAllBrand", Brand.class);
        return showAll.getResultList();
    }

    @Override
    public Optional<Brand> findBrandById(long id) {
        TypedQuery<Brand> findByFin = getEntityManager().createNamedQuery("findBrandById", Brand.class);
        findByFin.setParameter("id",id);
        Brand result = findByFin.getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public List<Brand> findBrandByName(String name) {
        TypedQuery findByName= getEntityManager().createNamedQuery("findBrandByName",Brand.class);
        return findByName.getResultList();
    }

    @Override
    public int updateBrand(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(brand);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);
        }
        return 1;
    }

    @Override
    public void deleteBrand(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().remove(brand);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY);
        }
    }
}
