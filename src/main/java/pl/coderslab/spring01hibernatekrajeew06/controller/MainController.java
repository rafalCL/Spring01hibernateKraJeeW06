package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew06.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.DogDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Dog;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

@Controller
public class MainController {
    private DogDao dogDao;
    private PublisherDao publisherDao;
    private BookDao bookDao;

    @Autowired
    public MainController(DogDao dogDao, PublisherDao publisherDao, BookDao bookDao) {
        this.dogDao = dogDao;
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @GetMapping("")
    public String main(){
        return "main";
    }

    @GetMapping("/add-dog/{name}")
    @ResponseBody
    public String addDog(@PathVariable String name){
        Dog dog = new Dog();
        dog.setName(name);

        this.dogDao.saveDog(dog);

        return "Zapisano: id=" + dog.getId() + ", name=" + dog.getName();
    }

    @GetMapping("/createpublisher")
    @ResponseBody
    public String createPublisher(@RequestParam String name){
        Publisher pub = new Publisher();
        pub.setName(name);

        this.publisherDao.create(pub);

        return "Zapisano: id=" + pub.getId() + ", name=" + pub.getName();
    }

    @GetMapping("/createbook")
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
