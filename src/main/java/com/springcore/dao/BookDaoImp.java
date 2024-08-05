package com.springcore.dao;


import com.springcore.entity.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImp implements BookDao{

    private JdbcTemplate template;


    @Override
    public String create(Book book) {
        String query = "INSERT INTO book(title,description,author) VALUES (?,?,?)";
        template.update(query,book.getTitle(),book.getDescription(),book.getAuthor());
        return "Book Title: "+ book.getTitle() +" added! ";
    }

    @Override
    public String update(Book book) {
        String query = "UPDATE book set title=?, description=?, author=? WHERE id=?";
        template.update(query,book.getTitle(),book.getDescription(),book.getAuthor(),book.getId());
        return "Updated to  "+ book.getTitle() +" where id= " + book.getId()+ "! ";
    }

    @Override
    public String delete(Book book) {
        String query = "DELETE FROM book where id=?";
        template.update(query,book.getId());
        return "Deleted book "+ book.getId();
    }

    @Override
    public List<Book> read() {
        String query = "SELECT * FROM book";
        return template.query(query, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getById(long id) {
        String  query = "SELECT * FROM book WHERE id=?";
       try{
           return template.queryForObject(query,new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
       }catch (EmptyResultDataAccessException e){
           return new Book();
       }
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
