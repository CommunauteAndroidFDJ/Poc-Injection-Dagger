package com.fdj.injection.injection.module.marvel

import com.fdj.injection.marvel.repository.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MarvelModule {

    @Provides
    internal fun provideMarvelApiInterface(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }
}