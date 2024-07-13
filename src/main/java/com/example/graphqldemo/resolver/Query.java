package com.example.graphqldemo.resolver;

import com.example.graphqldemo.model.Book;
import com.example.graphqldemo.model.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
