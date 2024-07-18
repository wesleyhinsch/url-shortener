package com.hinsch.wishlist.application.gateway;

import com.hinsch.wishlist.domain.entity.UrlDomain;

public interface UrlGateway {

    UrlDomain createUrl(UrlDomain urlDomain, String id);

    boolean existsById(String id);

    UrlDomain findById(String id) throws Exception;

}
