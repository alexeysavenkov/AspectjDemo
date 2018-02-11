package com.naukma.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BookDAO {
    @Bean("single-book")
    public static Book getSingleBook() {
        return new Book("Book 0");
    }

    @Bean("many-books")
    public static List<Book> getManyBooks() {
        return Arrays.asList(
                new Book("Book 1"),
                new Book("Book 2"),
                new Book("Book 3"),
                new Book("Book 4"),
                new Book("Book 5")
        );
    }
}
