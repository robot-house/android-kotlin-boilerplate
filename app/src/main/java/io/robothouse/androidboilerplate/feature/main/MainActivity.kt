package io.robothouse.androidboilerplate.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.robothouse.androidboilerplate.R
import io.robothouse.androidboilerplate.feature.BaseActivity

class MainActivity : BaseActivity() {

  companion object {
    fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
  }

  lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val screen = MainScreenImpl(this)
    presenter = MainPresenterImpl(screen)
    screen.registerEvents(presenter)
  }
}