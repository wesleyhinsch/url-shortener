package com.hinsch.wishlist.application.usecases;

import com.hinsch.wishlist.application.gateway.UrlGateway;
import com.hinsch.wishlist.domain.entity.UrlDomain;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CreateUrlUseCase {

    @Autowired
    UrlGateway urlGateway;

    public UrlDomain createUrl(UrlDomain urlDomain){

        var id = createDynamicId();

        return urlGateway.createUrl(urlDomain, id);
    }

    public UrlDomain findById(String id) throws Exception {
        return urlGateway.findById(id);
    }

    private String createDynamicId() {
        String id;

        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlGateway.existsById(id));

        return id;
    }

}
