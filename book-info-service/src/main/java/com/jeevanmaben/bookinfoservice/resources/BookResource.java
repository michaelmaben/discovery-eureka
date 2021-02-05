package com.jeevanmaben.bookinfoservice.resources;

import com.jeevanmaben.bookinfoservice.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/books")
public class BookResource {
    @RequestMapping(path="/{bookId}")
    public Book getBookInfo(@PathVariable String bookId){
        return new Book("1", "Book-Info-1");
    }
}
