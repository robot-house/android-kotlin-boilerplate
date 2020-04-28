package io.robothouse.androidboilerplate.feature.main

interface MainScreen {

  fun registerEvents(presenter: MainPresenter)

  fun startLoginActivity()
}