package com.glima.data.domain

import com.glima.domain.business.model.Breed

fun BreedResponse.asDomain() = Breed(
    id = id,
    name = name,
    description = description,
    lifeSpan = lifeSpan,
    origin = origin,
    isRare = isRare == 1,
    affectionLevel = affectionLevel,
    intelligence = intelligence
)