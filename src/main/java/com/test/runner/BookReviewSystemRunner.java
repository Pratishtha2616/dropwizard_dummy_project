package com.test.runner;

import com.test.config.BRSConfiguration;
import com.test.dao.BookReviewEntityDAO;
import com.test.entity.BookReviewEntity;
import com.test.resources.BookReviewResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class BookReviewSystemRunner extends Application <BRSConfiguration>{
    public static void main(String args[]) throws Exception {
        new BookReviewSystemRunner().run(args);
    }

    @Override
    public void run(BRSConfiguration brsConfigurationon, Environment environment) throws Exception {
        System.out.println("Running BookReviewSystem");
        BookReviewEntityDAO bookReviewEntityDAO=new BookReviewEntityDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new BookReviewResource(bookReviewEntityDAO));
    }


    //now we need to create the session factory
    HibernateBundle<BRSConfiguration> hibernateBundle = new HibernateBundle<BRSConfiguration>(BookReviewEntity.class){

        @Override
        public PooledDataSourceFactory getDataSourceFactory(BRSConfiguration brsConfiguration) {
            return brsConfiguration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<BRSConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

}
