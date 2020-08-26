package com.glima.ilovecats

import com.glima.domain.business.model.Breed

fun Breed.asViewObject() = BreedVO(
    id = id,
    name = name,
    description = description,
    lifeSpan = lifeSpan,
    origin = origin,
    isRare = isRare,
    affectionLevel = affectionLevel,
    intelligence = intelligence
)