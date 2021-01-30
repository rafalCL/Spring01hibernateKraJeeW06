package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrajeew06.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPublisher(@RequestParam String name){
        Publisher pub = new Publisher();
        pub.setName(name);

        this.publisherDao.create(pub);

        return "Zapisano: id=" + pub.getId() + ", name=" + pub.getName();
    }

    @GetMapping("/readbyid")
    @ResponseBody
    public String readById(@RequestParam int id){
        Publisher pub = this.publisherDao.readById(id);

        return "Wczytano: id=" + pub.getName() + ", books were not loaded.";
    }

    @GetMapping("/readbyidwb")
    @ResponseBody
    public String readByIdWb(@RequestParam int id){
        Publisher pub = this.publisherDao.readByIdWithBooks(id);

        return "Wczytano: id=" + pub.getName() + ", books=" + pub.getBooks().toString();
    }
}
