package io.robothouse.androidboilerplate.feature.main

import android.widget.Button
import io.robothouse.androidboilerplate.R
import io.robothouse.androidboilerplate.feature.BaseScreen
import io.robothouse.androidboilerplate.feature.landing.LandingActivity

class MainScreenImpl(activity: MainActivity) : BaseScreen(activity), MainScreen {

  private val logout: Button = activity.findViewById(R.id.btn_logout)

  override fun registerEvents(presenter: MainPresenter) {

    logout.setOnClickListener {
      presenter.onLogoutClick()
    }
  }

  override fun startLoginActivity() {
    activity.startActivity(LandingActivity.getIntent(activity))
    activity.finish()
  }
}