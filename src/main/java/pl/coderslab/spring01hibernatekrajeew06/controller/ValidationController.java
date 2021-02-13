package pl.coderslab.spring01hibernatekrajeew06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew06.dao.DogDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Book;
import pl.coderslab.spring01hibernatekrajeew06.entity.Dog;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

//Utwórz kontroler o nazwie ValidationController.
//Uzupełnij ziarno dla walidacji.
//Sprawdź działanie walidacji w akcji kontrolera dostępnej pod adresem /validate.


@Controller
public class ValidationController {
    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validateBook(){
        Book b = new Book();
        Set<ConstraintViolation<Book>> violations = this.validator.validate(b);

        if(violations.isEmpty()){
            return "Walidacja zakończona pomyślnie.";
        }

        String violationResultsStr = "";

        for (ConstraintViolation<Book> violation : violations){
            violationResultsStr += String.format("<div>%s : %s</div>\r\n",
                    violation.getPropertyPath(),  violation.getMessage());
        }

        return violationResultsStr;
    }
}
