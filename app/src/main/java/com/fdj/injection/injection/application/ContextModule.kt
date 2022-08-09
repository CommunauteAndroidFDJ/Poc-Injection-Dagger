package com.fdj.injection.injection.application

import android.content.Context
import com.fdj.injection.FdjInjectionApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {
    @Provides
    @Singleton
    internal fun provideContext(fdjInjectionApplication: FdjInjectionApplication): Context =
        fdjInjectionApplication.applicationContext
}
