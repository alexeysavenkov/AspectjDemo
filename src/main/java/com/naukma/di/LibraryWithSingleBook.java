package com.naukma.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class LibraryWithSingleBook extends Library {
    @Autowired
    private Book book;

    public LibraryWithSingleBook() {}
    public LibraryWithSingleBook(Book book) {
        this.book = book;
    }

    @Override
    public List<Book> getBooks() {
        return Collections.singletonList(book);
    }
}
