package com.microsoft.spring5.dao.daoImpl;

import com.microsoft.spring5.dao.BookDao;
import com.microsoft.spring5.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * 通过jdbcTemplate实现CRUD
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into book values(default, ?, ?)";
        jdbcTemplate.update(sql,2, "shit");
    }

    @Override
    public void update(Book book) {
        String sql = "update book set b_name=? where b_id =?;";
        Object[] args = {book.getBName(), book.getBId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(Book book) {
        String sql = "delete from book where b_id = ?";
        int update = jdbcTemplate.update(sql, book.getBId());
        System.out.println(update);
    }

    /**
     * 查询单个值
     * @return
     */
    @Override
    public int selectCount() {
        String sql = "select count(1) from book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 查询对象
     * @param bId
     * @return
     */
    @Override
    public Book selectBook(int bId) {
        String sql = "select * from book where b_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), bId);
    }

    @Override
    public List<Book> selectAllBook() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    /**
     * 批量增加 底层遍历list中的数组 然后每次都将数组中的参数填到sql中执行
     * @param args
     */
    @Override
    public void addBooks(List<Object[]> args) {
        String sql = "insert into book values(default, ?, ?)";
        jdbcTemplate.batchUpdate(sql, args);
    }

    /**
     * 批量修改
     * @param args
     * @return
     */
    public int updateBooks(List<Object[]> args) {
        String sql = "update book set b_name=? where b_id =?;";
        int[] changes;
        changes = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(changes));
        return 0;
    }

    /**
     * 批量删除
     * @param args
     * @return
     */
    @Override
    public int deleteBooks(List<Object[]> args) {
        String sql = "delete from book where b_id = ?";
        int[] changes;
        changes = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(changes));
        return 0;
    }
}
