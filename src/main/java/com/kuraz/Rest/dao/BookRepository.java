package com.kuraz.Rest.dao;
import com.kuraz.Rest.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
