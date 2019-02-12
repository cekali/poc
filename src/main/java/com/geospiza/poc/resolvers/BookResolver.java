package com.geospiza.poc.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.geospiza.poc.models.Author;
import com.geospiza.poc.models.Book;
import com.geospiza.poc.repositories.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {

        Author author = authorRepository.findById(book.getAuthor().getId()).get();
        return author;
    }
}
