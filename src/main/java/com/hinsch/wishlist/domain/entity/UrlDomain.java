package com.hinsch.wishlist.domain.entity;

import lombok.*;

import java.time.LocalDateTime;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UrlDomain{

    private String id;

    private String fullUrl;

    private LocalDateTime expiresAt;

}
