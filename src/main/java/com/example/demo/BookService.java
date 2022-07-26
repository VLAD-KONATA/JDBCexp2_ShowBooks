package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    public int addBook(Book book){
        return bookDao.addBook(book);
    }
    public int updateBook(Book book){
        return bookDao.update(book);
    }
    public int deleteBookById(Integer id){
        return bookDao.deleteBookById(id);
    }
    public Book getBookById(Integer id){
        return bookDao.getBookById(id);
    }
    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
}