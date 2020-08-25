package com.glima.domain.business.model

data class Breed(
    val id: String,
    val name: String,
    val description: String,
    val lifeSpan: String,
    val origin: String,
    val isRare: Boolean,
    val affectionLevel: Int,
    val intelligence: Int
)