package com.example.web.service;

import com.example.web.model.binding.BookBinding;

import java.util.List;

public interface BookService {
    Long addBook(BookBinding bookBinding);

    List<BookBinding> getAll();

    BookBinding getById(Long id);

    boolean deleteById(Long id);

    boolean update(BookBinding setId);
}
