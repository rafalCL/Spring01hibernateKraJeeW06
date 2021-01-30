package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Dog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DogDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveDog(Dog dog){
        this.entityManager.persist(dog);
    }
}
