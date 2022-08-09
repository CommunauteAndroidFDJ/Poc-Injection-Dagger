package com.fdj.injection.injection.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.fdj.injection.FdjInjectionApplication
import com.fdj.injection.injection.application.AppComponent
import com.fdj.injection.injection.application.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

object AppInjector {

    fun init(
        fdjInjectionApplication: FdjInjectionApplication
    ): AppComponent {

        fdjInjectionApplication.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(
                    activity
                )
            }

            override fun onActivityStarted(activity: Activity) {
                // Optional method
            }

            override fun onActivityResumed(activity: Activity) {
                // Optional method
            }

            override fun onActivityPaused(activity: Activity) {
                // Optional method
            }

            override fun onActivityStopped(activity: Activity) {
                // Optional method
            }

            override fun onActivityDestroyed(activity: Activity) {
                // Optional method
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                // Optional method
            }
        })

        val component = DaggerAppComponent.builder()
            .application(fdjInjectionApplication)
            .build()


        component.inject(fdjInjectionApplication)
        return component
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasAndroidInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fm: FragmentManager,
                            f: Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
        }
    }
}
