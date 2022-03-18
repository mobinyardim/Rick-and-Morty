package ir.mobinyardim.app.chractersrepository.network

import ir.mobinyardim.app.chractersrepository.network.responses.CharacterResponse
import ir.mobinyardim.app.chractersrepository.network.responses.GetAllCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("character")
    suspend fun getAllCharacters(

    ): GetAllCharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path(value = "id") id: Int
    ): CharacterResponse
}