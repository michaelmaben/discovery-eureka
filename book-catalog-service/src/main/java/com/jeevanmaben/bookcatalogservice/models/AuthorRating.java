package com.jeevanmaben.bookcatalogservice.models;

import java.util.List;

public class AuthorRating {
    List<Rating> userRatings;

    public AuthorRating(){

    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public AuthorRating(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
