package io.robothouse.androidboilerplate.dagger2

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class ReactiveModule {

  @Singleton
  @Provides
  @Named("mainThread")
  fun provideMainThreadScheduler(): Scheduler {
    return AndroidSchedulers.mainThread()
  }

  @Singleton
  @Provides
  @Named("io")
  fun provideIoScheduler(): Scheduler {
    return Schedulers.io()
  }

  @Singleton
  @Provides
  @Named("computation")
  fun provideComputationScheduler(): Scheduler {
    return Schedulers.computation()
  }
}