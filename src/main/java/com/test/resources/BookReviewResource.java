package com.test.resources;

import com.test.dao.BookReviewEntityDAO;
import com.test.entity.BookReviewEntity;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.util.Date;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookReviewResource {

    private final BookReviewEntityDAO bookReviewEntityDAO;

    public BookReviewResource(BookReviewEntityDAO bookReviewEntityDAO) {
        this.bookReviewEntityDAO = bookReviewEntityDAO;
    }

    @GET
    @Path("/healthCheck")
    public String healthCheck() {
        return "Ping received at " + new Date();
    }

    @POST
    @Path("/review")
    @UnitOfWork
    public String postReview(@Valid BookReviewEntity bookReviewEntity) {
        System.out.println("Received BookReviewEntity++++++++: " + bookReviewEntity);
        System.out.println("ID: " + bookReviewEntity.getId());
        System.out.println("Book ID: " + bookReviewEntity.getBookId());
        System.out.println("Rating: " + bookReviewEntity.getRating());
        System.out.println("Review: " + bookReviewEntity.getReview());
        System.out.println("---------------");
        //System.out.println(bookReviewEntity);
        if (bookReviewEntity.getBookId() == null || bookReviewEntity.getBookId().isEmpty()) {
            throw new IllegalArgumentException("book_id cannot be null or empty");
        }
        return bookReviewEntityDAO.save(bookReviewEntity).getId();
    }


    @GET
    @Path("/review")
    @UnitOfWork
    public BookReviewEntity getReview(@QueryParam("id") String id) {
        return bookReviewEntityDAO.findById(id); // Change this line
    }



}
