package io.robothouse.androidboilerplate.feature.main

import io.robothouse.androidboilerplate.feature.BasePresenter

class MainPresenterImpl(private val screen: MainScreen) : BasePresenter(), MainPresenter {

  override fun onLogoutClick() {
    authManager.signOut()
    screen.startLoginActivity()
  }
}