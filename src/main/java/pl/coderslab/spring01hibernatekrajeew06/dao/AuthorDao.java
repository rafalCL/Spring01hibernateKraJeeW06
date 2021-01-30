package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}
