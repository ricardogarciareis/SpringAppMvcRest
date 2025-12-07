package local.lab.dzrrcreations.spring_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.lab.dzrrcreations.spring_app.entity.Book;
import local.lab.dzrrcreations.spring_app.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book updateTitle(Long id, String title) {
        Optional<Book> bookToUpdate = bookRepository.findById(id);
        bookToUpdate.get().setTitle(title);
        return bookRepository.save(bookToUpdate.get());
    }

    public Book updateAuthor(Long id, String author) {
        Optional<Book> bookToUpdate = bookRepository.findById(id);
        bookToUpdate.get().setTitle(author);
        return bookRepository.save(bookToUpdate.get());
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
