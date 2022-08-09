package com.fdj.injection.injection.module

import com.fdj.injection.marvel.ui.character.detail.CharacterDetailFragment
import com.fdj.injection.marvel.ui.character.list.CharacterListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FdjInjectionBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeCharacterListFragment(): CharacterListFragment

    @ContributesAndroidInjector
    abstract fun contributeCharacterDetailFragment(): CharacterDetailFragment
}