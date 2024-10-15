package com.test.dao;

import com.mysql.cj.util.StringUtils;
import com.test.entity.BookReviewEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class BookReviewEntityDAO extends AbstractDAO<BookReviewEntity> {

    public BookReviewEntityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    // You can add methods to interact with the BookReviewEntity here

    public BookReviewEntity findById(String id) {
        return get(id);
    }


    public BookReviewEntity save(BookReviewEntity bookReviewEntity) {
        if(StringUtils.isNullOrEmpty(bookReviewEntity.getId()))
        bookReviewEntity.setId(UUID.randomUUID().toString());
        return persist(bookReviewEntity);//functions already available in AbstractDAO
    }
}





