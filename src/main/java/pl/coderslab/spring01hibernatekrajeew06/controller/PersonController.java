package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.spring01hibernatekrajeew06.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

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
        m.addAttribute("person", p);

        return "person/details";
    }
}
