package ir.mobinyardim.app.chractersrepository

import ir.mobinyardi.app.database.models.CharacterEntity
import ir.mobinyardim.app.chractersrepository.network.responses.CharacterResponse
import ir.mobinyardim.app.models.Character


fun CharacterResponse.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        gender = when (gender) {
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