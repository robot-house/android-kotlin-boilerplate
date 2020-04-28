package io.robothouse.androidboilerplate.feature.landing

interface LandingPresenter {

  fun onResume()

  fun onLoginClick(email: String, password: String)

  fun onRegisterClick()

  fun onDestroy()
}