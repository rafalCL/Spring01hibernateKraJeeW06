package pl.coderslab.spring01hibernatekrajeew06.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernatekrajeew06.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrajeew06.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String idAsString) {
        return this.authorDao.readById(Integer.valueOf(idAsString));
    }
}
