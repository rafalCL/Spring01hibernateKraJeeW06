package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring01hibernatekrajeew06.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

import java.util.List;

//W projekcie Spring01hibernate utwórz kontroler BookFormController, umieścimy w nim akcje odpowiedzialne za operacje na obiektach typu Book z wykorzystaniem formularzy.
//        Utwórz formularz, który pozwoli dodać obiekt klasy Book.
//        Utwórz akcję wyświetlającą formularz.
//        Dodaj akcję obsługującą dane z formularza,
//        Dodaj możliwość wyboru wydawcy z listy rozwijalnej.
//        Zapisz obiekt do bazy danych.

@Controller
@RequestMapping("/bookform")
public class BookFormController {
    private BookDao bookDao;
    private PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/list")
    public String list(){
        return "book/list";
    }

    @GetMapping("/add")
    public String add(Model m){
        m.addAttribute("book", new Book());

        return "book/book-form";
    }

    @PostMapping("/add")
    public String addPost(Book book){
        this.bookDao.create(book);

        return "redirect:list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return this.publisherDao.readAll();
    }

    @ModelAttribute("books")
    public List<Book> books(){
        return this.bookDao.readAll();
    }
}