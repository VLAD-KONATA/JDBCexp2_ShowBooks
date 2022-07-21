package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/bookOps")
    public void bookOps(){
        Book b1=new Book();
        b1.setName("ArtemisFowl");
        b1.setAuthor("Colfer");
        int i=bookService.addBook(b1);
        System.out.println("Add Book>>>"+i);
        Book b2=new Book();
        b2.setId(1);
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅");
        int updateBook=bookService.updateBook(b2);
        System.out.println("Update Book>>>"+updateBook);
        Book b3=bookService.getBookById(1);
        System.out.println("getBookById>>>"+b3.getName()+" "+b3.getAuthor());
        int delete=bookService.deleteBookById(2);
        System.out.println("Add Book>>>"+delete);
        List<Book> allBooks=bookService.getAllBooks();
        System.out.println("getAllBooks>>>"+allBooks);
    }
    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> books = new ArrayList<>();
        books=bookService.getAllBooks();
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }
}