package com.example.web.service.impl;

import com.example.web.model.Author;
import com.example.web.repo.AuthorRepository;
import com.example.web.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public Author getAuthor(String author) {
      return  authorRepository.findByName(author).orElse(null);
    }

    @Override
    public Author createAuthor(String author) {
        Author author1=new Author();
        author1.setName(author);
        authorRepository.save(author1);
        return author1;
    }
}
