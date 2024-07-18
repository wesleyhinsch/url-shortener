package com.hinsch.wishlist.infrastructure.controllers.mapper;

import com.hinsch.wishlist.domain.entity.UrlDomain;
import com.hinsch.wishlist.infrastructure.controllers.dto.request.ShortenUrlRequest;
import com.hinsch.wishlist.infrastructure.controllers.dto.response.ShortenUrlResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UrlDtoMapper {

   public ShortenUrlResponse toResponse(UrlDomain urlDomain){
         return ShortenUrlResponse.builder()
                 .url(urlDomain.getFullUrl())
                 .build();
    }

    public UrlDomain toUrlDomain(ShortenUrlRequest shortenUrlRequest){
        return UrlDomain.builder()
                .fullUrl(shortenUrlRequest.getUrl())
                .build();
    }

    public ShortenUrlResponse toRedirect(String string){
        return ShortenUrlResponse.builder()
                .url(string)
                .build();
    }

}
