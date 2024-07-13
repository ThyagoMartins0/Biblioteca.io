package com.example.graphqldemo.resolver;

import com.example.graphqldemo.model.Book;
import com.example.graphqldemo.model.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(String title, String author, int pages) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, String title, String author, int pages) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setPages(pages);
            return bookRepository.save(book);
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return !bookRepository.existsById(id);
    }
}
