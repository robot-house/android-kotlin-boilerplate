package io.robothouse.androidboilerplate.feature.register

import io.robothouse.androidboilerplate.feature.BasePresenter

class RegisterPresenterImpl(
  private val screen: RegisterScreen
) : BasePresenter(), RegisterPresenter {

  override fun onResume() {
    if (authManager.isLoggedIn()) screen.startMainActivity()
  }

  override fun onRegisterClick(username: String, email: String, password: String) {
    if (screen.checkUsernameNotEmpty()
      && screen.checkEmailNotEmpty()
      && screen.checkPasswordNotEmpty()
    ) {
      collect(
        authManager
          .register(username, email, password)
          .doOnSubscribe { screen.showRegisterLoader(true) }
          .subscribe({
            screen.startMainActivity()
          }, {
            screen.showRegisterLoader(false)
            screen.showToast(it.message!!)
            it.printStackTrace()
          })
      )
    }
  }

  override fun onLoginClick() {
    screen.startLoginActivity()
  }

  override fun onDestroy() {
    dispose()
  }
}