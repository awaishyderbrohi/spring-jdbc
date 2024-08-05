package com.springcore.dao;


import com.springcore.entity.Book;

import java.util.List;

public interface BookDao {
    public String create(Book book);
    public String update(Book book);
    public String delete(Book book);
    public List<Book> read();
    public Book getById(long id);
}
