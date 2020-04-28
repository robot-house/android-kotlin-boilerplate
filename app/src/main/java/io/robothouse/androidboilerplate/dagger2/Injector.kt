package io.robothouse.androidboilerplate.dagger2

import android.app.Application
import io.robothouse.androidboilerplate.feature.BasePresenter
import io.robothouse.androidboilerplate.feature.BaseScreen

object Injector : MainComponent {

  private var component: MainComponent? = null

  fun init(application: Application) {

    if (component != null) {
      throw RuntimeException("Can't init twice!")
    }

    component = DaggerMainComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
  }

  override fun inject(baseScreen: BaseScreen) {
    component?.inject(baseScreen)
  }

  override fun inject(basePresenter: BasePresenter) {
    component?.inject(basePresenter)
  }
}