package com.example.web.model.binding;

import com.example.web.model.Author;

import javax.persistence.ManyToOne;

public class BookBinding {
    private Long id;
    private String title;
    private String isbn;

    private String author;

    public BookBinding(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public BookBinding() {
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public BookBinding setId(Long id) {
        this.id = id;
        return this;
    }

    public BookBinding setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookBinding setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookBinding setAuthor(String author) {
        this.author = author;
        return this;
    }
}
