package io.robothouse.androidboilerplate.manager

import com.google.firebase.auth.AuthResult
import io.reactivex.Maybe

interface AuthManager {

  fun login(email: String, password: String): Maybe<AuthResult>

  fun register(username: String, email: String, password: String): Maybe<AuthResult>

  fun isLoggedIn(): Boolean

  fun signOut()
}