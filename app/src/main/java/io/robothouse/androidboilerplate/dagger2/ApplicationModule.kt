package io.robothouse.androidboilerplate.dagger2

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.robothouse.androidboilerplate.manager.AuthManager
import io.robothouse.androidboilerplate.manager.AuthManagerImpl
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

  @Singleton
  @Provides
  fun provideApplication(): Application {
    return application
  }

  @Singleton
  @Provides
  fun provideResources(): Resources {
    return application.resources
  }

  @Singleton
  @Provides
  fun provideAuthManager(): AuthManager {
    return AuthManagerImpl()
  }
}