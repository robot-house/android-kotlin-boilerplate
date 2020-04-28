package io.robothouse.androidboilerplate.handler

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task

import io.reactivex.MaybeEmitter

class RxHandler<T> private constructor(
  private val emitter: MaybeEmitter<in T>
) : OnSuccessListener<T>, OnFailureListener, OnCompleteListener<T> {

  override fun onSuccess(res: T?) {
    if (res != null) {
      emitter.onSuccess(res)
    } else {
      emitter.onError(RxFirebaseNullDataException("Observables can't emit null values"))
    }
  }

  override fun onComplete(task: Task<T>) {
    emitter.onComplete()
  }

  override fun onFailure(e: Exception) {
    if (!emitter.isDisposed)
      emitter.onError(e)
  }

  companion object {
    fun <T> assignOnTask(emitter: MaybeEmitter<in T>, task: Task<T>) {
      val handler = RxHandler(emitter)
      task.addOnSuccessListener(handler)
      task.addOnFailureListener(handler)
      try {
        task.addOnCompleteListener(handler)
      } catch (t: Throwable) {
        //ignore
      }
    }
  }

  private class RxFirebaseNullDataException : NullPointerException {

    constructor()

    constructor(detailMessage: String) : super(detailMessage)

    constructor(resultException: Exception?) : super(if (resultException != null) resultException.message else DEFAULT_MESSAGE)

    companion object {
      private const val DEFAULT_MESSAGE = "Task result was successful but data was empty"
    }
  }
}