package com.naukma.di;

import java.util.List;

abstract class Library {
    abstract List<Book> getBooks();

    public String info() {
        StringBuilder sb = new StringBuilder("Books in library: <ul>");
        for(Book book : getBooks()) {
            sb.append("<li>");
            sb.append(book.getName());
            sb.append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }
}
