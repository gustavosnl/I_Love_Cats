package com.glima.data.domain

import com.glima.domain.business.model.Breed
import com.glima.domain.business.model.BreedImage

fun BreedResponse.asDomain() = Breed(
    id = id,
    name = name,
    description = description,
    lifeSpan = lifeSpan,
    isRare = isRare == 1,
    affectionLevel = affectionLevel,
    intelligence = intelligence
)

fun BreedImageResponse.asDomain() = BreedImage(
    id = id,
    url = url
)