package io.robothouse.androidboilerplate.feature

import android.widget.Toast
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

open class BaseScreen(val activity: BaseActivity) {

  @Inject
  @field:[Named("io")]
  lateinit var io: Scheduler

  @Inject
  @field:[Named("mainThread")]
  lateinit var main: Scheduler

  @Inject
  @field:[Named("computation")]
  lateinit var computation: Scheduler

  fun showToast(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
  }
}