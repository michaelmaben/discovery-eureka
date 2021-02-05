package com.jeevanmaben.bookratingservice.resources;

import com.jeevanmaben.bookratingservice.models.Rating;
import com.jeevanmaben.bookratingservice.models.AuthorRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataService {
    @RequestMapping("/{bookId}")
    public Rating getBookRating(@PathVariable String bookId){
        return new Rating("1", 3);
    }

    @RequestMapping("/authors/{authorId}")
    public AuthorRating getBookRating(){
        return new AuthorRating(Arrays.asList(
                new Rating("Book-Info-1", 5),
                new Rating("book-Info-2", 4)
            )
        );
    }
}
