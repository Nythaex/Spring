package com.example.web.service;

import com.example.web.model.Author;

public interface AuthorService {
    Author getAuthor(String author);

   Author createAuthor(String author);
}
