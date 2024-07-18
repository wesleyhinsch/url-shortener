package com.hinsch.wishlist.infrastructure.controllers;


import com.hinsch.wishlist.application.usecases.CreateUrlUseCase;
import com.hinsch.wishlist.infrastructure.controllers.dto.request.ShortenUrlRequest;
import com.hinsch.wishlist.infrastructure.controllers.dto.response.ShortenUrlResponse;
import com.hinsch.wishlist.infrastructure.controllers.mapper.UrlDtoMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {

    @Autowired
    CreateUrlUseCase createUrlUseCase;

    @Autowired
    UrlDtoMapper urlDtoMapper;

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest,
                                                         HttpServletRequest servletRequest) {

        var urlDomain = urlDtoMapper.toUrlDomain(shortenUrlRequest);

        var createdUrl = createUrlUseCase.createUrl(urlDomain);

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", createdUrl.getId());

        var response = urlDtoMapper.toRedirect(redirectUrl);

        return ResponseEntity.ok(response);

    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id) {

        HttpHeaders headers = new HttpHeaders();

        try{

            var urlDomainFound = createUrlUseCase.findById(id);

            headers.setLocation(URI.create(urlDomainFound.getFullUrl()));

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
