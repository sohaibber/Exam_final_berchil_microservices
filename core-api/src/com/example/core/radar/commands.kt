package com.example.core.radar

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier
    open val id : T
)
data class CreateRadarCommand(
    override val id : String,
    val vitesse : Double,
    val longtitude : String,
    val latitude : String
):BaseCommand<String>(id)

data class UpdateRadarCommand(
    override val id:String,
    val vitesse : Double,
    val longtitude : String,
    val latitude : String
):BaseCommand<String>(id)