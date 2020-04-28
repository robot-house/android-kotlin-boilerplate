package io.robothouse.androidboilerplate.feature.landing

interface LandingScreen {

  fun registerEvents(presenter: LandingPresenter)

  fun startRegisterActivity()

  fun startMainActivity()

  fun showLoginLoader(show: Boolean)

  fun showToast(message: String)

  fun checkEmailNotEmpty(): Boolean

  fun checkPasswordNotEmpty(): Boolean
}