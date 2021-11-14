package com.example.web.service.impl;

import com.example.web.model.Author;
import com.example.web.model.Book;
import com.example.web.model.binding.BookBinding;
import com.example.web.repo.BookRepository;
import com.example.web.service.AuthorService;
import com.example.web.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private AuthorService authorService;
    private ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long addBook(BookBinding bookBinding) {
        Book map = modelMapper.map(bookBinding, Book.class);
        Author author = authorService.getAuthor(bookBinding.getAuthor());
        if (author==null){
            Author newAuthor = authorService.createAuthor(bookBinding.getAuthor());
            map.setAuthor(newAuthor);
        }else {
         map.setAuthor(author);
        }
        Book save = bookRepository.save(map);

        return save.getId();
    }

    @Override
    public List<BookBinding> getAll() {
      return  bookRepository.findAll().stream().map(s->modelMapper.map(s,BookBinding.class).setAuthor(s.getAuthor().getName())).collect(Collectors.toList());

    }

    @Override
    public BookBinding getById(Long id) {
       return bookRepository.findById(id).map(s->modelMapper.map(s,BookBinding.class).setAuthor(s.getAuthor().getName())).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        bookRepository.deleteById(id);
        return false;
    }

    @Override
    public boolean update(BookBinding setId) {
        Book byId = bookRepository.findById(setId.getId()).orElse(null);
        if (byId==null){
            return false;
        }

        byId.setIsbn(setId.getIsbn()).setTitle(setId.getTitle()).setAuthor(authorService.getAuthor(setId.getAuthor()));
        bookRepository.save(byId);
        return true;
    }
}
