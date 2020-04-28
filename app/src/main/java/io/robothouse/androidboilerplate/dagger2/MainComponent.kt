package io.robothouse.androidboilerplate.dagger2

import dagger.Component
import io.robothouse.androidboilerplate.feature.BaseActivity
import io.robothouse.androidboilerplate.feature.BasePresenter
import io.robothouse.androidboilerplate.feature.BaseScreen
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ReactiveModule::class])
interface MainComponent {

  fun inject(baseScreen: BaseScreen)

  fun inject(basePresenter: BasePresenter)
}