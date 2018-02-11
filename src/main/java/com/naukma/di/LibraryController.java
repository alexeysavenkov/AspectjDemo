package com.naukma.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LibraryController {

    @Autowired
    LibraryWithSingleBook librarySingle;
    @Autowired
    LibraryWithManyBooks libraryMany;

    @RequestMapping("/library-single")
    public String librarySingle() {
        return librarySingle.info();
    }

    @RequestMapping("/library-many")
    public String libraryMany() {
        return libraryMany.info();
    }

    private ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("app-config.xml");
    }

}