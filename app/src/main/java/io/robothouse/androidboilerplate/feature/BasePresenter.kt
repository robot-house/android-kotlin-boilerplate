package io.robothouse.androidboilerplate.feature

import android.content.res.Resources
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.robothouse.androidboilerplate.dagger2.Injector
import io.robothouse.androidboilerplate.manager.AuthManager
import javax.inject.Inject
import javax.inject.Named

open class BasePresenter {

  @Inject
  @field:[Named("io")]
  lateinit var io: Scheduler

  @Inject
  @field:[Named("mainThread")]
  lateinit var main: Scheduler

  @Inject
  @field:[Named("computation")]
  lateinit var computation: Scheduler

  @Inject
  lateinit var resources: Resources

  @Inject
  lateinit var authManager: AuthManager

  init {
    Injector.inject(this)
  }

  private val disposables = CompositeDisposable()

  fun getString(id: Int): String {
    return resources.getString(id)
  }

  @Synchronized
  fun collect(disposable: Disposable) {
    disposables.add(disposable)
  }

  @Synchronized
  fun dispose() {
    disposables.clear()
  }
}