package com.example.radar.commands.controllers;

import com.example.core.radar.CreateRadarCommand;
import com.example.core.radar.CreateRadarRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radars")
public class RadarController {
    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public CompletableFuture<String> newCustomer(@RequestBody CreateRadarRequestDTO request){
        CompletableFuture<String> response = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitesse(),
                request.getLongtitude(),
                request.getLatitude()
        ));
        return response;
    }
    @PostMapping("/update/{id}")
    public CompletableFuture<String> updateCustomer(@RequestBody CreateRadarRequestDTO request){
        CompletableFuture<String> response = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitesse(),
                request.getLongtitude(),
                request.getLatitude()
        ));
        return response;
    }
    @GetMapping("/eventStore/{radarId}")
    public Stream eventStore(@PathVariable String customerId){
        return eventStore.readEvents(customerId).asStream();
    }
}
