package com.fdj.injection.marvel.business

import com.fdj.injection.base.data.BaseResponse
import com.fdj.injection.base.domain.UseCase
import com.fdj.injection.marvel.business.model.MarvelCharacter
import com.fdj.injection.marvel.repository.MarvelRepository
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository
) : UseCase<BaseResponse<MarvelCharacter?>, GetCharacterDetailUseCase.Params>() {

    override suspend fun run(params: Params): BaseResponse<MarvelCharacter?> =
        marvelRepository.getCharacterDetail(params.characterId)


    data class Params(val characterId: String)
}