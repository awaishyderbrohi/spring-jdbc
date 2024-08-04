package com.springcore;

import com.springcore.dao.BookDao;
import com.springcore.dao.BookDaoImp;
import com.springcore.entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ApplicationContext context = new  ClassPathXmlApplicationContext("config.xml");
        BookDao bookDao =  context.getBean("bookDaoImp", BookDaoImp.class);

//        INSERT
//        Book book = new Book();
//        book.setTitle("CI/CD Jinkin");
//        book.setDescription("This Book is for those who wants to master CI/CD piplines and most recommended for Software Engineer");
//        book.setAuthor("Awais Hyder");
//        String result = bookDao.create(book);
//        System.out.println(result);


////       UPDATE
//        Book book = new Book();
//        book.setId(2);
//        book.setTitle("Docker for Buddies");
//        book.setDescription("This Book is for those who wants to learn Docker basics, most recommended for DevOps Engineers and also Software Engineer");
//        book.setAuthor("Awais Hyder");
//        String result = bookDao.update(book);
//        System.out.println(result);

////      Delete
//        Book book = new Book();
//        book.setId(1);
//        String result = bookDao.delete(book);
//        System.out.println(result);

////      Read
//      List<Book> bookList = bookDao.read();
//        bookList.forEach(System.out::println);



        System.out.println(bookDao.getById(7));
    }
}
