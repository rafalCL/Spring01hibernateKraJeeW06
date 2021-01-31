package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.spring01hibernatekrajeew06.dao.PersonDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/addform")
    public String addForm(){
        return "person/addform";
    }

    @PostMapping("/addform")
    public String addFormPost(@RequestParam String login,
                              @RequestParam String password,
                              @RequestParam String email,
                              Model m){
        Person p = new Person(login, password, email);

        this.personDao.create(p);

        m.addAttribute("person", p);

        return "person/details";
    }

    @GetMapping("/addformbind")
    public String addFormBind(Model m){
        m.addAttribute("person", new Person());

        return "person/addformbind";
    }

    @PostMapping("/addformbind")
    public String addFormBindPost(Person person,
                                  Model m){
        this.personDao.create(person);

        m.addAttribute("person", person);

        return "person/details";
    }
}
