package com.example.web.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author extends BasicEntity{

    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, List<Book> boos) {
        this.name = name;
        this.books = boos;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public List<Book> getBoos() {
        return books;
    }

    public Author setBoos(List<Book> boos) {
        this.books = boos;
        return this;
    }
}
