package com.hinsch.wishlist.infrastructure.gateway.mappers;

import com.hinsch.wishlist.domain.entity.UrlDomain;
import com.hinsch.wishlist.infrastructure.persistence.entity.UrlEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class UrlEntityMapper {

    public UrlEntity toEntity(UrlDomain urlDomain, String id){
        return UrlEntity.builder()
                .id(id)
                .expiresAt(LocalDateTime.now().plusMinutes(1))
                .fullUrl(urlDomain.getFullUrl())
                .build();
    }

    public UrlDomain toDomain(UrlEntity urlEntity){
        return UrlDomain.builder()
                .id(urlEntity.getId())
                .fullUrl(urlEntity.getFullUrl())
                .expiresAt(urlEntity.getExpiresAt())
                .build();
    }

}
