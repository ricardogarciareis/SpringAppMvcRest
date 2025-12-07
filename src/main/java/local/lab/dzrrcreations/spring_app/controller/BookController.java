package local.lab.dzrrcreations.spring_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;

import local.lab.dzrrcreations.spring_app.dto.PostBookDto;
import local.lab.dzrrcreations.spring_app.entity.Book;
import local.lab.dzrrcreations.spring_app.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveANewBook(PostBookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book findABookById(@PathVariable("id") Long id) {
        return bookService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    @PutMapping("/title/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateABookTitle(@PathVariable("id") Long id, @RequestBody String title) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        if (book != null) {
            return bookService.updateTitle(id, title);
        }
        return null;
    }

    @PutMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateABookAuthor(@PathVariable("id") Long id, @RequestBody String author) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        if (book != null) {
            return bookService.updateAuthor(id, author);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteABook(@PathVariable("id") Long id) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        if (book != null) {
            bookService.deleteById(id);
        }
    }
}
