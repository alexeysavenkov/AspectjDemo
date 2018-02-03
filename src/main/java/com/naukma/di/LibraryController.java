package com.naukma.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LibraryController {

    @RequestMapping("/library-single")
    public String librarySingle() {
        ApplicationContext context = getContext();
        Library library = (Library)context.getBean("library-single");
        return library.info();
    }

    @RequestMapping("/library-many")
    public String libraryMany() {
        ApplicationContext context = getContext();
        Library library = (Library)context.getBean("library-many");
        return library.info();
    }

    private ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("app-config.xml");
    }

}