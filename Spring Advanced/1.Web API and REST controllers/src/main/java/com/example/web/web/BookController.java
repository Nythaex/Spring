package com.example.web.web;

import com.example.web.model.Book;
import com.example.web.model.binding.BookBinding;
import com.example.web.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @GetMapping("/books")
    public ResponseEntity<List<BookBinding>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }


    @ResponseBody
    @PatchMapping("/books")
    public ResponseEntity<BookBinding> addBook(@RequestBody BookBinding bookBinding, UriComponentsBuilder uriBuilder) {
        Long id = bookService.addBook(bookBinding);
        URI build = uriBuilder.build("/home/" + id);
        return ResponseEntity.created(build).build();
    }

    @ResponseBody
    @GetMapping("books/{id}")
    public ResponseEntity<BookBinding> getBooks(@PathVariable Long id) {
        BookBinding bookBinding = bookService.getById(id);
        if (bookBinding == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookBinding);

    }

    @ResponseBody
    @DeleteMapping("books/{id}")
    public ResponseEntity<BookBinding> deleteBook(@PathVariable Long id){
       bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @PatchMapping("books/{id}")
    public ResponseEntity<BookBinding> updateBook(@PathVariable Long id,@RequestBody BookBinding bookBinding){
        boolean found=bookService.update(bookBinding.setId(id));
        return found?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
