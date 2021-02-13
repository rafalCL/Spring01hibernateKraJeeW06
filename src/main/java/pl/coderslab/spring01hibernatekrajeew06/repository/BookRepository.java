package pl.coderslab.spring01hibernatekrajeew06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Category;

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
}
