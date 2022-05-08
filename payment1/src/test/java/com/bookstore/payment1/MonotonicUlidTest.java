package com.bookstore.payment1;

import com.bookstore.payment1.service.UlidCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
public class MonotonicUlidTest {

    @Autowired
    private UlidCreator ulidCreator;

    @Test
    public void monotonicUlidTest() {
        var ulid = ulidCreator.monotincUlid();
        var ulid2 = ulidCreator.monotincUlid();

        System.out.println(ulid);
        System.out.println(ulid2);
    }

}
