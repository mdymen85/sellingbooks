package com.sellingbooks.buy;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DataController {

    private final DynamoDBLoadService dynamoDBLoadService;

    @RequestMapping(value = "/v1/load", method = RequestMethod.GET)
    public ResponseEntity<AuthorResponse> load(@RequestBody SearchCriteria searchCriteria) throws JsonProcessingException {

        var author = this.dynamoDBLoadService.createDynamoDBTables(searchCriteria.getId(), searchCriteria.getName());



        return new ResponseEntity<AuthorResponse>(author, HttpStatus.ACCEPTED);

    }

    //public void buy(@RequestBody Boo)

}
