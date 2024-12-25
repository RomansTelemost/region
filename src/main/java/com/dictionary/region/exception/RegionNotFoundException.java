package com.dictionary.region.exception;

public class RegionNotFoundException extends RuntimeException {

    public RegionNotFoundException() {
        super("Region not found");
    }
}
