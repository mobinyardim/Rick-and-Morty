package ir.mobinyardim.rickandmorty.chractersrepository.converter

import ir.mobinyardim.rickandmorty.database.models.CharacterEntity
import ir.mobinyardim.rickandmorty.chractersrepository.network.responses.CharacterResponse
import ir.mobinyardim.app.models.Character


fun CharacterResponse.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        gender = when (gender.lowercase()) {
            "male" -> Character.Gender.MALE
            "female" -> Character.Gender.FEMALE
            else -> Character.Gender.UNKNOWN
        },
        image = image,
        location = Character.Location(
            name = location.name,
            url = url
        ),
        origin = Character.Origin(
            name = origin.name,
            url = origin.url
        ),
        species = species,
        status = when (status) {
            "dead" -> Character.Status.DEAD
            "alive" -> Character.Status.ALIVE
            else -> Character.Status.UNKNOWN
        },
        type = type,
        url = url
    )
}

fun Character.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        gender = gender.name,
        image = image,
        location = CharacterEntity.Location(
            name = location.name,
            url = url
        ),
        origin = CharacterEntity.Origin(
            name = origin.name,
            url = origin.url
        ),
        species = species,
        status = status.name,
        type = type,
        url = url,
    )
}


fun CharacterEntity.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        gender = Character.Gender.valueOf(gender),
        image = image,
        location = Character.Location(
            name = location.name,
            url = url
        ),
        origin = Character.Origin(
            name = origin.name,
            url = origin.url
        ),
        species = species,
        status = Character.Status.valueOf(status),
        type = type,
        url = url,
    )
}