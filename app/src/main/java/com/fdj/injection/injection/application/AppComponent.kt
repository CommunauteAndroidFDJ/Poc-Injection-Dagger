package com.fdj.injection.injection.application

import com.fdj.injection.FdjInjectionApplication
import com.fdj.injection.injection.module.FdjInjectionActivityModule
import com.fdj.injection.injection.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContextModule::class,
        FdjInjectionActivityModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(fdjInjectionApplication: FdjInjectionApplication): Builder

        fun build(): AppComponent
    }

    fun inject(fdjInjectionApplication: FdjInjectionApplication)
}
