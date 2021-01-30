package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew06.dao.DogDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Dog;

@Controller
public class MainController {
    private DogDao dogDao;

    @Autowired
    public MainController(DogDao dogDao) {
        this.dogDao = dogDao;
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
}
