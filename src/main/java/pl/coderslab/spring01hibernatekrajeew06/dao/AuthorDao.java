package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Author;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Author author){
        this.em.persist(author);
    }

    public Author readById(int id) {
        return this.em.find(Author.class, id);
    }

    public List<Author> readAll() {
        final Query q = this.em.createQuery("SELECT e FROM Author e");

        return q.getResultList();
    }
}
