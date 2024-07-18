package com.hinsch.wishlist.infrastructure.gateway;

import com.hinsch.wishlist.application.gateway.UrlGateway;
import com.hinsch.wishlist.domain.entity.UrlDomain;
import com.hinsch.wishlist.infrastructure.gateway.exceptions.UrlNotFoundException;
import com.hinsch.wishlist.infrastructure.gateway.mappers.UrlEntityMapper;
import com.hinsch.wishlist.infrastructure.persistence.UrlRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UrlRepositoryGateway implements UrlGateway {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlEntityMapper urlEntityMapper;

    @Override
    public UrlDomain createUrl(UrlDomain urlDomain, String id) {
        var urlEntity = urlEntityMapper.toEntity(urlDomain, id);
        var urlEntitySave =  urlRepository.save(urlEntity);
        return urlEntityMapper.toDomain(urlEntitySave);
    }

    @Override
    public boolean existsById(String id) {
        return urlRepository.existsById(id);
    }

    @Override
    public UrlDomain findById(String id) throws Exception {
        var urlEntityFound = urlRepository.findById(id);
        if(urlEntityFound.isEmpty())
            throw new UrlNotFoundException("Url Not Found");
        return urlEntityMapper.toDomain(urlEntityFound.get());
    }

}
