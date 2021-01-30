package pl.coderslab.spring01hibernatekrajeew06.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Publisher setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Publisher setName(String name) {
        this.name = name;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Publisher setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
