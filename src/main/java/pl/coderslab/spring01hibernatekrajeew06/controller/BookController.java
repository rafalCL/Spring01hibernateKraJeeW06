package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrajeew06.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;
    private PublisherDao publisherDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
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
}
