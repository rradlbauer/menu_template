package at.spengergasse;

import at.spengergasse.entities.DemoEntity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaDemo {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence
                   .createEntityManagerFactory("demo")
                   .createEntityManager();
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setText("Hello World");
        entityManager.getTransaction().begin();
        entityManager.persist(demoEntity);
        entityManager.getTransaction().commit();
        System.out.println(demoEntity);
        entityManager.close();

    }
}
