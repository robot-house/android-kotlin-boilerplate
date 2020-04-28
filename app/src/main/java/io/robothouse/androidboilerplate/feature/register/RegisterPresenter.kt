package io.robothouse.androidboilerplate.feature.register

interface RegisterPresenter {

  fun onResume()

  fun onRegisterClick(username: String, email: String, password: String)

  fun onLoginClick()

  fun onDestroy()
}