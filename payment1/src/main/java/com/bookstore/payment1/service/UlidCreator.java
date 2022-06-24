package com.bookstore.payment1.service;

import com.github.f4b6a3.ulid.Ulid;
import org.springframework.stereotype.Component;

public class UlidCreator {

    public static Ulid monotincUlid() {
        return com.github.f4b6a3.ulid.UlidCreator.getMonotonicUlid();
    }

}
