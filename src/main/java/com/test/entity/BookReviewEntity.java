package com.test.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.criteria.CriteriaBuilder;

@Entity//entity name of the table used in the code
@Table(name="book_review")//name of the table in the database

public class BookReviewEntity {

    //@Id
    @Id
    private String id;

     @JsonProperty("book_id")
    @Column(name="book_id",nullable = false)
    private String book_id;

    @Column(name="rating")
    private Integer rating;

    @Column(name="review")
    private String review;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return book_id;
    }

    public void setBookId(String bookId) {
        this.book_id= bookId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
