package com.kuraz.Rest.Service;

import com.kuraz.Rest.dao.BookRepository;
import com.kuraz.Rest.entity.Book;
import com.kuraz.Rest.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private BookRepository BookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        BookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return BookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {

        Optional<Book> result = BookRepository.findById(theId);
        Book theBook = null;
        if(result.isPresent())
        {
            theBook = result.get();
        }
        else {
            throw new RuntimeException("Didn't find and Book id" + theId);
        }
        return  theBook;

    }
    @Override
    public Book save(Book theBook) {
        return BookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        BookRepository.deleteById(theId);

    }
}
