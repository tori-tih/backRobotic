package com.example.backrobotic.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PathImage {
    IMAGE_PATH("src/main/resources/image/");
    private final String path ;
}
