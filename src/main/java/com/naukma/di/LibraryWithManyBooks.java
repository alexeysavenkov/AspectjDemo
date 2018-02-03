package com.naukma.di;

import java.util.List;

public class LibraryWithManyBooks extends Library {
    List<Book> books;
    public LibraryWithManyBooks() { }
    public LibraryWithManyBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
