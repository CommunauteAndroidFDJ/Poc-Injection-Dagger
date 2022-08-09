package com.fdj.injection.injection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fdj.injection.marvel.ui.character.detail.CharacterDetailViewModel
import com.fdj.injection.marvel.ui.character.list.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    abstract fun bindCharacterListViewModel(characterListViewModel: CharacterListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailViewModel::class)
    abstract fun bindCharacterDetailViewModel(characterDetailViewModel: CharacterDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factoryView: FdjInjectionViewModelFactory): ViewModelProvider.Factory

}
