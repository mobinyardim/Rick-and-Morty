package ir.mobinyardi.app.database.models


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "created")
    val created: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "image")
    val image: String,
    @Embedded
    val location: Location,
    @ColumnInfo(name = "name")
    val name: String,
    @Embedded
    val origin: Origin,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "url")
    val url: String
) {

    data class Location(
        @ColumnInfo(name = "location_name")
        val name: String,
        @ColumnInfo(name = "location_url")
        val url: String
    )

    data class Origin(
        @ColumnInfo(name = "origin_name")
        val name: String,
        @ColumnInfo(name = "origin_url")
        val url: String
    )
}