package ir.mobinyardim.app.chractersrepository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.mobinyardim.app.chractersrepository.network.Api
import ir.mobinyardim.app.chractersrepository.converter.toCharacter
import ir.mobinyardim.app.models.Character
import javax.inject.Inject

class CharactersPagingSource @Inject constructor(
    private val api: Api
) : PagingSource<String, Character>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> {
        return try {
            val response = if (params.key != null)
                api.getAllCharacters(params.key!!)
            else
                api.getAllCharacters()

            LoadResult.Page(
                response.characters.map { it.toCharacter() },
                response.info.prev,
                response.info.next
            )
        } catch (e:Exception) {
            LoadResult.Error(e)
        }
    }


    override fun getRefreshKey(state: PagingState<String, Character>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}