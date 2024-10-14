package com.test.resources;

import com.test.dao.BookReviewEntityDAO;
import com.test.entity.BookReviewEntity;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.Date;

@Path("/book")

public class BookReviewResource {

    private final BookReviewEntityDAO bookReviewEntityDAO;

    public BookReviewResource(BookReviewEntityDAO bookReviewEntityDAO) {
        this.bookReviewEntityDAO = bookReviewEntityDAO;
    }

     @GET
     @Path("/healthCheck")
    public String healthCheck(){
        return "Ping received at"+new Date();
    }



}
