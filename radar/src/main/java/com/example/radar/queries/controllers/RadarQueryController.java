package com.example.radar.queries.controllers;

import com.example.radar.queries.entities.Radar;
import com.example.radarqueryside.entities.radar;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.query.GetAllradarsQuery;
import org.sid.coreapi.query.GetradarByIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radars/query")
public class radarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/getAll")
    public CompletableFuture<List<Radar>> radars(){
        return queryGateway.query(new GetAllRadarsQuery(),
                ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/radarbyId/{id}")
    public CompletableFuture<Radar> getradar(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id),
                ResponseTypes.instanceOf(Radar.class));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String > responseEntity=
                new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
