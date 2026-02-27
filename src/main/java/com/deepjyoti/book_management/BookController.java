package com.deepjyoti.book_management;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(201).body(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }

    @PutMapping("{id}")
    public void updateProduct(@PathVariable Integer id,
                              @RequestParam String title,
                              @RequestParam String author,
                              @RequestParam Float price){
        bookService.updateBook(id, title, author, price);
    }
}
