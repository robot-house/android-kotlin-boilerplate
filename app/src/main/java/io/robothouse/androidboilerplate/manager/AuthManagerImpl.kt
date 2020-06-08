package io.robothouse.androidboilerplate.manager

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.robothouse.androidboilerplate.constants.DATA_USERS
import io.robothouse.androidboilerplate.model.User
import io.robothouse.androidboilerplate.handler.RxHandler

class AuthManagerImpl : AuthManager {

  private val firebaseAuth = FirebaseAuth.getInstance()
  private val firebaseDb = FirebaseFirestore.getInstance()

  override fun login(email: String, password: String): Maybe<AuthResult> {
    return Maybe.create<AuthResult> { emitter ->
      RxHandler.assignOnTask(
        emitter,
        firebaseAuth.signInWithEmailAndPassword(email, password)
      )
    }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  override fun register(username: String, email: String, password: String): Maybe<AuthResult> {
    return Maybe.create<AuthResult> { emitter ->
      RxHandler.assignOnTask(
        emitter,
        firebaseAuth.createUserWithEmailAndPassword(email, password)
      )
    }
      .map {
        val user = User(username, email, "")
        firebaseDb.collection(DATA_USERS).document(firebaseAuth.uid!!).set(user)
        it
      }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  override fun isLoggedIn(): Boolean = !firebaseAuth.currentUser?.uid.isNullOrEmpty()

  override fun signOut() {
    firebaseAuth.signOut()
  }
}