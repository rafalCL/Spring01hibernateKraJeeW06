package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Publisher publisher){
        this.em.persist(publisher);
    }

    public Publisher readById(int id) {
        return this.em.find(Publisher.class, id);
    }

    public Publisher readByIdWithBooks(int id) {
        Publisher pub =  this.em.find(Publisher.class, id);
        Hibernate.initialize(pub.getBooks());

        return pub;
    }
}
