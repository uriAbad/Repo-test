package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.ArtistInfo
import uriabad.com.startapp.network.appendHttpsPrefix
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.ArtistDataEntity

fun ArtistDataEntity.toArtistInfo() = ArtistInfo(
        id.safe(),
        name.safe(),
        birthDate.safe(),
        deathDate.safe(),
        city.safe(),
        country.safe(),
        descriptionText.safe(),
        backgroundImage.safe(),
        image.safe().appendHttpsPrefix(),
        href.safe(),
        categories.safe(),
        origin.safe())
