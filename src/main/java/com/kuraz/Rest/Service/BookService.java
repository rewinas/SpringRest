package com.kuraz.Rest.Service;

import com.kuraz.Rest.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(int theId);
    Book save(Book theBook);
    void deleteById(int theId);
}
