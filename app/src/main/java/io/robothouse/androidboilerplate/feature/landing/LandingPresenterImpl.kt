package io.robothouse.androidboilerplate.feature.landing

import io.robothouse.androidboilerplate.feature.BasePresenter

class LandingPresenterImpl(
  private val screen: LandingScreen
) : LandingPresenter, BasePresenter() {

  override fun onResume() {
    if (authManager.isLoggedIn()) screen.startMainActivity()
  }

  override fun onLoginClick(email: String, password: String) {
    if (screen.checkEmailNotEmpty() && screen.checkPasswordNotEmpty()) {
      collect(
        authManager
          .login(email, password)
          .doOnSubscribe { screen.showLoginLoader(true) }
          .subscribe({
            screen.startMainActivity()
          }, {
            screen.showLoginLoader(false)
            screen.showToast(it.message!!)
            it.printStackTrace()
          })
      )
    }
  }

  override fun onRegisterClick() {
    screen.startRegisterActivity()
  }

  override fun onDestroy() {
    dispose()
  }
}