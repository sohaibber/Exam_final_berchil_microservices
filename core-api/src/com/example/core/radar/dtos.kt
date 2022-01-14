package com.example.core.radar

data class CreateRadarRequestDTO(
    var vitesse : Double,
    var longtitude : String,
    var latitude : String
)
data class UpdateRadarRequestDTO(
    var id : String,
    var vitesse : Double,
    var longtitude : String,
    var latitude : String
)