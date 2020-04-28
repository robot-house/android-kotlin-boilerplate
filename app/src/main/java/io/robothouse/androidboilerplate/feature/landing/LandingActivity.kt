package io.robothouse.androidboilerplate.feature.landing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.robothouse.androidboilerplate.R
import io.robothouse.androidboilerplate.feature.BaseActivity

class LandingActivity : BaseActivity() {

  companion object {
    fun getIntent(context: Context) = Intent(context, LandingActivity::class.java)
  }

  lateinit var presenter: LandingPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_landing)
    val screen = LandingScreenImpl(this)
    presenter = LandingPresenterImpl(screen)
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
