package com.microsoft.spring5.service;

import com.microsoft.spring5.dao.BookDao;
import com.microsoft.spring5.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public void add(Book book) {
        bookDao.add(book);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public int findCount() {
        return bookDao.selectCount();
    }

    public Book findBook(int b_id) {
        return bookDao.selectBook(b_id);
    }

    public List<Book> findBooks() {
        return bookDao.selectAllBook();
    }

    public void addBooks(List<Object[]> args) {
        bookDao.addBooks(args);
    }

    public int updateBooks(List<Object[]> args) {
        return bookDao.updateBooks(args);
    }

    public int deleteBooks(List<Object[]> args) {
        return bookDao.deleteBooks(args);
    }
}
