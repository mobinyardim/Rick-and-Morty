package ir.mobinyardim.app.models

data class Character(
    val id: Int,
    val name: String,
    val gender: Gender,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: Status,
    val type: String,
    val url: String,
    val isSaved: Boolean = false
) {

    enum class Gender {
        FEMALE,
        MALE,
        GENDERLESS,
        UNKNOWN
    }

    enum class Status {
        ALIVE,
        DEAD,
        UNKNOWN
    }

    data class Location(
        val name: String,
        val url: String
    )

    data class Origin(
        val name: String,
        val url: String
    )
}