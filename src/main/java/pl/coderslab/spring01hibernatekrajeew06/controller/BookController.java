package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrajeew06.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Author;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createBook(@RequestParam String title, @RequestParam int pubId){
        Publisher pub = this.publisherDao.readById(pubId);

        Book book = new Book();
        book.setTitle(title);
        book.setPublisher(pub);

        this.bookDao.create(book);

        return "Zapisano: id=" + book.getId() + ", title=" + book.getTitle();
    }

    @GetMapping("/createwithauthors")
    @ResponseBody
    public String createBookWithAuthors(@RequestParam String title){
        Publisher pub = this.publisherDao.readById(1);
        Author author1 = this.authorDao.readById(1);
        Author author2 = this.authorDao.readById(2);

        Book book = new Book();
        book.setTitle(title);
        book.setPublisher(pub);
        book.getAuthors().add(author1);
        book.getAuthors().add(author2);

        this.bookDao.create(book);

        return "Zapisano: id=" + book.getId() + ", title=" + book.getTitle();
    }

    @GetMapping("/findbyidwa")
    @ResponseBody
    public String findByIdWithAuthors(@RequestParam int bookId){
        Book book = this.bookDao.readByIdWithAuthors(bookId);

        return "Zapisano: id=" + book.getId() + ", title=" + book.getTitle() + ", authors="+book.getAuthors().toString();
    }

    @GetMapping("/list")
    public String readAll(Model m) {
        List<Book> books = this.bookDao.readAll();
        m.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listrating")
    public String readByRatingGTE(@RequestParam int minRating, Model m) {
        List<Book> books = this.bookDao.readByRatingGTE(minRating);
        m.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listwp")
    public String readAllHavingPublisher(Model m) {
        List<Book> books = this.bookDao.readAllHavingPublisher();
        m.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbypubid")
    public String listByPubId(@RequestParam int pubId, Model m) {
        Publisher p = this.publisherDao.readById(pubId);
        List<Book> books = this.bookDao.readAllHavingPublisherEQ(p);
        m.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbypubname")
    public String listByPubName(@RequestParam String pubName, Model m) {
        List<Book> books = this.bookDao.readAllHavingPublisherName(pubName);
        m.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbyauthid")
    public String listByAuthId(@RequestParam int authId, Model m) {
        Author a = this.authorDao.readById(authId);
        List<Book> books = this.bookDao.readAllHavingAuthor(a);
        m.addAttribute("books", books);

        return "book/list";
    }
}
