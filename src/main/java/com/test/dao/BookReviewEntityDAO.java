package com.test.dao;

import com.test.entity.BookReviewEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class BookReviewEntityDAO extends AbstractDAO<BookReviewEntity> {

    public BookReviewEntityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    // You can add methods to interact with the BookReviewEntity here

    public BookReviewEntity findById(int id) {
        return get(id);
    }

    public BookReviewEntity save(BookReviewEntity bookReviewEntity) {
        bookReviewEntity.setId(UUID.randomUUID().toString());
        return persist(bookReviewEntity);//functions already available in AbstractDAO
    }
}

