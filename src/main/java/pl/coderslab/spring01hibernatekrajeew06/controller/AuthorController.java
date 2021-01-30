package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew06.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrajeew06.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Author;
import pl.coderslab.spring01hibernatekrajeew06.entity.Publisher;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(@RequestParam String fn, @RequestParam String ln){
        Author author = new Author();
        author.setFirstName(fn);
        author.setLastName(ln);

        this.authorDao.create(author);

        return "Zapisano: id=" + author.getId() + ", name=" + author.getFullName();
    }

    @GetMapping("/readbyid")
    @ResponseBody
    public String readById(@RequestParam int id){
        Author author = this.authorDao.readById(id);

        return "Wczytano: id=" + author.getId() + ", name=" + author.getFullName();
    }

//    @GetMapping("/readbyidwb")
//    @ResponseBody
//    public String readByIdWb(@RequestParam int id){
//        Publisher pub = this.publisherDao.readByIdWithBooks(id);
//
//        return "Wczytano: id=" + pub.getName() + ", books=" + pub.getBooks().toString();
//    }
}
