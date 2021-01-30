package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Book book){
        this.em.persist(book);
    }
}
