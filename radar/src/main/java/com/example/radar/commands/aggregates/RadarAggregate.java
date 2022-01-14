package com.example.radar.commands.aggregates;

import com.example.core.radar.CreateRadarCommand;
import com.example.core.radar.RadarCreatedEvent;
import com.example.core.radar.RadarUpdatedEvent;
import com.example.core.radar.UpdateRadarCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private String RadarId;
    private Double vitesse;
    private String longtitude;
    private String latitude;

    public RadarAggregate() {
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {
        log.info("*********************************");
        log.info("CreateRadarCommand received");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getVitesse(),
                command.getLongtitude(),
                command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        log.info("RadarCreatedEvent occured");
        this.RadarId=event.getId();
        this.vitesse=event.getVitesse();
        this.latitude=event.getLatitude();
        this.longtitude =event.getLongtitude();
        AggregateLifecycle.apply(new RadarCreatedEvent(this.RadarId,this.vitesse,this.latitude,this.longtitude));

    }
    @CommandHandler
    public void on(UpdateRadarCommand command) {
        log.info("*********************************");
        log.info("UpdateRadarCommand received");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getVitesse(),
                command.getLongtitude(),
                command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on(RadarUpdatedEvent event){
        log.info("RadarUpdatedEvent occured");
        this.RadarId=event.getId();
        this.vitesse=event.getVitesse();
        this.latitude=event.getLatitude();
        this.longtitude =event.getLongtitude();
        AggregateLifecycle.apply(new RadarCreatedEvent(this.RadarId,this.vitesse,this.latitude,this.longtitude));

    }
}