package com.hinsch.wishlist.infrastructure.controllers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ShortenUrlRequest {
    private String url;
}
