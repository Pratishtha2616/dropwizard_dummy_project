//package com.test.resources;
//
//import com.test.dao.BookReviewEntityDAO;
//import com.test.entity.BookReviewEntity;
//import io.dropwizard.hibernate.UnitOfWork;
//import jakarta.validation.Valid;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.QueryParam;
//
//import java.util.Date;
//
//@Path("/book")
//
//public class BookReviewResource {
//
//    private final BookReviewEntityDAO bookReviewEntityDAO;
//
//    public BookReviewResource(BookReviewEntityDAO bookReviewEntityDAO) {
//        this.bookReviewEntityDAO = bookReviewEntityDAO;
//    }
//
//     @GET
//     @Path("/healthCheck")
//    public String healthCheck(){
//        return "Ping received at"+new Date();
//    }
//
//
//    //to save the book review
//    @POST
//    @Path("/review")
//    @UnitOfWork
//    public String postReview(@Valid BookReviewEntity bookReviewEntity){
//        return bookReviewEntityDAO.save(bookReviewEntity).getId();
//    }
//
//    @GET
//    @Path("/review")
//    @UnitOfWork
//    public BookReviewEntity getReview(@QueryParam("book_id")String book_id){
//        return bookReviewEntityDAO.find(book_id);
//    }
//
//
//
//}





package com.test.resources;

import com.test.dao.BookReviewEntityDAO;
import com.test.entity.BookReviewEntity;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.Date;

@Path("/book")
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

    // to save the book review
    @POST
    @Path("/review")
    @UnitOfWork
    public String postReview(@Valid BookReviewEntity bookReviewEntity) {
        return bookReviewEntityDAO.save(bookReviewEntity).getId();
    }

//    @GET
//    @Path("/review")
//    @UnitOfWork
//    public BookReviewEntity getReview(@QueryParam("id") String id) {
//        return bookReviewEntityDAO.findById(id); // Change this line
//    }
}
