package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Author;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Person;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Person entity){
        this.em.persist(entity);
    }

    public void update(Person entity){
        this.em.merge(entity);
    }

    public Person readById(int id) {
        return this.em.find(Person.class, id);
    }

    public List<Person> readAll() {
        final Query query = this.em.createQuery("SELECT e FROM Person e");
        final List<Person> entities = query.getResultList();

        return entities;
    }
}
