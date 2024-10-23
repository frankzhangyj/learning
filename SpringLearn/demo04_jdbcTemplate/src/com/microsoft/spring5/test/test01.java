package com.microsoft.spring5.test;

import com.microsoft.spring5.pojo.Book;
import com.microsoft.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class test01 {
    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBId(4);
        book.setUId(2);
        book.setBName("nihao");
        bookService.update(book);

        System.out.println(bookService.findCount());

        System.out.println(bookService.findBook(4));

        List<Book> books = bookService.findBooks();
        books.forEach(System.out::println);


        Object[] o1 = {4};
        Object[] o2 = {5};
        Object[] o3 = {6};
        List<Object[]> books1 = new ArrayList<>();
        books1.add(o1);
        books1.add(o2);
        books1.add(o3);

        bookService.deleteBooks(books1);
    }
}
