package com.guomei.dao;

import com.guomei.pojo.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsDao extends MongoRepository<News,String> {
        public News findByTitle(String title);
}
