package pl.coderslab.spring01hibernatekrajeew06.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Book book){
        this.em.persist(book);
    }

    public Book readById(int id) {
        return this.em.find(Book.class, id);
    }

    public Book readByIdWithAuthors(int id) {
        Book book =  this.em.find(Book.class, id);
        Hibernate.initialize(book.getAuthors());

        return book;
    }

    public List<Book> readAll() {
        final Query query = this.em.createQuery("SELECT b FROM Book b");
        final List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> readByRatingGTE(int rating) {
        final Query query = this.em.createQuery("SELECT b FROM Book b WHERE b.rating >= :toCompare");
        query.setParameter("toCompare", rating);
        final List<Book> books = query.getResultList();

        return books;
    }
}
