package pl.coderslab.spring01hibernatekrajeew06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // metodę wyszukującą książki dla zadanego tytułu.
    List<Book> readByTitle(String title);
    List<Book> readByTitleContainingIgnoreCase(String part);
    //metodę wyszukującą książki dla zadanej kategorii
    List<Book> readByCategory(Category category);
    List<Book> readByCategoryIn(List<Category> categories);
    //metodę wyszukującą książki dla zadanego id kategorii
    List<Book> readByCategoryId(int categoryId);
    List<Book> readByCategoryName(String name);

    // with custom query:
    // metodę wyszukującą książki dla zadanego tytułu.
    @Query("SELECT e FROM Book e WHERE e.title=?1")
    List<Book> readCustomByTitle(String title);

    //metodę wyszukującą książki dla zadanej kategorii
    @Query("SELECT e FROM Book e WHERE e.category=?1")
    List<Book> readCustomByCategory(Category catToFind);

    //
    @Modifying
    @Transactional
    @Query("DELETE FROM Book e WHERE e.title LIKE ?1%")
    int misterKilerDoYourJob(String firstLetter);
}
