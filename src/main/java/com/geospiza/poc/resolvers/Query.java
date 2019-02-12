package com.geospiza.poc.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.geospiza.poc.models.Author;
import com.geospiza.poc.models.Book;
import com.geospiza.poc.repositories.AuthorRepository;
import com.geospiza.poc.repositories.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}