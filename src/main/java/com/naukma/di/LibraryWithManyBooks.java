package com.naukma.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryWithManyBooks extends Library {
    // Suppressing fake warning for 'many-books' selector
    // Code works 100%
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Qualifier("many-books")
    private List<Book> books;
    public LibraryWithManyBooks() { }
    public LibraryWithManyBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
