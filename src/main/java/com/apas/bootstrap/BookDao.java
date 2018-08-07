/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.bootstrap;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ekaranja
 */

@Component
public interface BookDao {

    public boolean addBook(Book book);

    public void updateBook(Book book);

    public List<Book> listBooks();

    public Book getBookById(Integer bookId);

    public boolean removeBook(Book book);

}
