package com.deepjyoti.book_management;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllProducts(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException(id));
    }

    public Book updateBook(Integer id, String title, String author, Float price){
        Book book = bookRepository.findById(id).orElseThrow(()->
                new BookNotFoundException(id));
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        bookRepository.save(book);
        return book;
    }
}
