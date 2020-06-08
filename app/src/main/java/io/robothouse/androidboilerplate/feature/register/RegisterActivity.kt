package io.robothouse.androidboilerplate.feature.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.robothouse.androidboilerplate.R
import io.robothouse.androidboilerplate.feature.BaseActivity

class RegisterActivity : BaseActivity() {

  companion object {
    fun getIntent(context: Context) = Intent(context, RegisterActivity::class.java)
  }

  private lateinit var presenter: RegisterPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register)
    val screen: RegisterScreen = RegisterScreenImpl(this)
    presenter = RegisterPresenterImpl(screen)
    screen.registerEvents(presenter)
  }

  override fun onResume() {
    super.onResume()
    presenter.onResume()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }
}