package com.jeevanmaben.bookcatalogservice.resources;

import com.jeevanmaben.bookcatalogservice.models.Book;
import com.jeevanmaben.bookcatalogservice.models.CatalogItem;
import com.jeevanmaben.bookcatalogservice.models.AuthorRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/catalog")
public class BookCatalogResource {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(path="/{authorId}")
    public List<CatalogItem> getCatalog(@PathVariable  String authorId) {

        AuthorRating authorRating = restTemplate.getForObject("http://book-rating-service/ratingsdata/authors/" + authorId,
                AuthorRating.class);
        return authorRating.getUserRatings().stream().map(rating -> {
                Book book = restTemplate.getForObject(
                        "http://book-info-service/books/" + rating.getBookId(), Book.class);
                return new CatalogItem(book.getName(),
                        "Fiction category", rating.getRating());

            }
        ).collect(Collectors.toList());
    }
}
