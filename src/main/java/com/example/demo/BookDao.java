package com.example.demo;

import com.example.demo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addBook(Book book){
        return jdbcTemplate.update("INSERT INTO book(Name,Author) VALUES(?,?)" ,book.getName(),book.getAuthor());
    }
    public int update(Book book){
        return jdbcTemplate.update("UPDATE book SET Name=?,Author=? WHERE Id=?",book.getName(),book.getAuthor(),book.getId());
    }
    public int deleteBookById(Integer Id){
        return jdbcTemplate.update("DELETE from book WHERE Id=?",Id);
    }
    public Book getBookById(Integer Id){
        return jdbcTemplate.queryForObject("select * from book where Id=?",new BeanPropertyRowMapper<>(Book.class),Id);
    }
    public List<Book> getAllBooks(){
        return jdbcTemplate.query("select * from book",new BeanPropertyRowMapper<>(Book.class));
    }
}