package com.naukma.di;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LibraryWithSingleBook extends Library {
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
