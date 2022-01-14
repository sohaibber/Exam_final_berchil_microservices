package com.example.core.radar

abstract class BaseEvent<T>(
    open val id : T
)
data class RadarCreatedEvent(
    override val id:String,
    val vitesse : Double,
    val longtitude : String,
    val latitude : String
):BaseEvent<String>(id)

data class RadarUpdatedEvent(
    override val id:String,
    val vitesse : Double,
    val longtitude : String,
    val latitude : String
):BaseEvent<String>(id)

