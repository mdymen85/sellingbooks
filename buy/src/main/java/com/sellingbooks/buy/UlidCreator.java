package com.sellingbooks.buy;

import com.github.f4b6a3.ulid.Ulid;
import org.springframework.stereotype.Component;

@Component
public class UlidCreator {

    public Ulid monotincUlid() {
        return com.github.f4b6a3.ulid.UlidCreator.getMonotonicUlid();
    }

}
