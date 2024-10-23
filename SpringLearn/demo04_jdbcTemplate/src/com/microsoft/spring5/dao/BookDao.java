package com.microsoft.spring5.dao;

import com.microsoft.spring5.pojo.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(Book book);

    int selectCount();

    Book selectBook(int bId);

    List<Book> selectAllBook();

    void addBooks(List<Object[]> args);

    int updateBooks(List<Object[]> args);

    int deleteBooks(List<Object[]> args);
}
