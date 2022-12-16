package ir.mobinyardim.rickandmorty.chractersrepository.network

import ir.mobinyardim.rickandmorty.chractersrepository.network.responses.CharacterResponse
import ir.mobinyardim.rickandmorty.chractersrepository.network.responses.GetAllCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface Api {

    @GET
    suspend fun getAllCharacters(
        @Url url: String = "https://rickandmortyapi.com/api/character"
    ): GetAllCharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path(value = "id") id: Int
    ): CharacterResponse
}