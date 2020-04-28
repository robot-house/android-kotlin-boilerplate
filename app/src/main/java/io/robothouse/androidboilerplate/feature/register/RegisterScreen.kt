package io.robothouse.androidboilerplate.feature.register

interface RegisterScreen {

  fun registerEvents(presenter: RegisterPresenter)

  fun checkUsernameNotEmpty(): Boolean

  fun checkEmailNotEmpty(): Boolean

  fun checkPasswordNotEmpty(): Boolean

  fun showRegisterLoader(show: Boolean)

  fun startLoginActivity()

  fun startMainActivity()

  fun showToast(message: String)
}