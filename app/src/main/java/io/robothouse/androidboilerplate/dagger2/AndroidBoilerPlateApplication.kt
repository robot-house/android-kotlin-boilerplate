package io.robothouse.androidboilerplate.dagger2

import android.app.Application

class AndroidBoilerPlateApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    Injector.init(this)
  }
}