package com.fdj.injection.injection.module

import com.fdj.injection.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FdjInjectionActivityModule {

    @ContributesAndroidInjector(modules = [FdjInjectionBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}