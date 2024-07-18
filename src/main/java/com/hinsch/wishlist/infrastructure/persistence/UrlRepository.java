package com.hinsch.wishlist.infrastructure.persistence;

import com.hinsch.wishlist.infrastructure.persistence.entity.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {
}
