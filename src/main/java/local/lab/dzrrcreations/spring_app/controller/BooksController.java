package local.lab.dzrrcreations.spring_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import local.lab.dzrrcreations.spring_app.entity.Book;
import local.lab.dzrrcreations.spring_app.service.BookService;


@Controller
@RequestMapping("/mvc/book")
public class BooksController {
	
	@Autowired
	private Environment env;

    @Autowired
    private BookService bookService;
    

    @GetMapping("/list")
    public String getBookPage(Model model) {   	
    	List<Book> books = bookService.findAll();
    	model.addAttribute("books", books);
    	model.addAttribute("env", env.getActiveProfiles()[0]);
    	return "book_page";
    }

    @PostMapping("/new")
    //public String postBookSubmit(@ModelAttribute("bookDto") PostBookDto bookDto, Model model) {
    public String postBook(@RequestParam(required=true, name="title") String title, @RequestParam(required=true, name="author") String author, Model model) {
    	Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookService.save(book);
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
    	return "redirect:/mvc/book/list";
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("book", book);
        return "edit_page";
    }
    
    @PostMapping("/update")
    public String updateBook(Book book) {
        bookService.save(book);
        return "redirect:/mvc/book/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
    	Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        bookService.deleteById(book.getId());
        return "redirect:/mvc/book/list";
    }
    
}

// Spring MVC Thymeleaf Tutorial with CRUD Example and Source Code
// https://www.youtube.com/watch?v=do7XqcaIkVk

// http://localhost:18300/mvc/book/list
// http://localhost:18300/swagger-ui/index.html
