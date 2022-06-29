package com.bookstore.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Transactional
public class StockController {

    private final SellRepository sellRepository;
    private final BookRepository bookRepository;

    @RequestMapping(path = "/v1/sell", method = RequestMethod.POST)
    public ResponseEntity<SellResponse> comprar(@RequestBody SellRequest sell) {

        var optBook = this.bookRepository.findByBookUuid(sell.getBookId());
        if (!optBook.isPresent()) {
            throw new RuntimeException();
        }

        var book = optBook.get();

        var newStock = book.getStock() - sell.getQuantity();

        if (newStock < 0) {
            throw new RuntimeException();
        }

        book.setStock(newStock);

        var sellCommand = Sell
                .builder()
                .bookId(sell.getBookId())
                .quantity(sell.getQuantity())
                .build();

        this.sellRepository.save(sellCommand);

        var response = SellResponse.builder()
                .bookId(sellCommand.getBookId())
                .stock(book.getStock())
                .bought(sellCommand.getBought())
                .quantity(sellCommand.getQuantity())
                .build();

        return new ResponseEntity<SellResponse>(response, HttpStatus.ACCEPTED);
    }

}
