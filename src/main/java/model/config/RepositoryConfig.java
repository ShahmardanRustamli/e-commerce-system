package model.config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RepositoryConfig {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    protected RepositoryConfig() {
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }
}
