package io.robothouse.androidboilerplate.feature.register

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.robothouse.androidboilerplate.feature.BaseScreen
import io.robothouse.androidboilerplate.feature.landing.LandingActivity
import io.robothouse.androidboilerplate.R
import io.robothouse.androidboilerplate.feature.main.MainActivity
import io.robothouse.androidboilerplate.util.TextWatcher

class RegisterScreenImpl(
  activity: RegisterActivity
) : BaseScreen(activity), RegisterScreen {

  private val etUsername: TextInputEditText = activity.findViewById(R.id.et_username)
  private val tilUsername: TextInputLayout = activity.findViewById(R.id.til_username)
  private val etEmail: TextInputEditText = activity.findViewById(R.id.et_email)
  private val tilEmail: TextInputLayout = activity.findViewById(R.id.til_email)
  private val etPassword: TextInputEditText = activity.findViewById(R.id.et_password)
  private val tilPassword: TextInputLayout = activity.findViewById(R.id.til_password)
  private val register: TextView = activity.findViewById(R.id.btn_signup)
  private val login: TextView = activity.findViewById(R.id.tv_login)
  private val registerLoader: LinearLayout = activity.findViewById(R.id.register_progress_layout)

  override fun registerEvents(presenter: RegisterPresenter) {

    register.setOnClickListener {
      presenter.onRegisterClick(
        etUsername.text.toString(),
        etEmail.text.toString(),
        etPassword.text.toString()
      )
    }
    login.setOnClickListener {
      presenter.onLoginClick()
    }

    etUsername.addTextChangedListener(object : TextWatcher() {
      override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
        tilUsername.isErrorEnabled = false
      }
    })
    etEmail.addTextChangedListener(object : TextWatcher() {
      override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
        tilEmail.isErrorEnabled = false
      }
    })
    etPassword.addTextChangedListener(object : TextWatcher() {
      override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
        tilPassword.isErrorEnabled = false
      }
    })
  }

  override fun checkUsernameNotEmpty(): Boolean {
    if (etUsername.text.isNullOrEmpty()) {
      tilUsername.error = activity.getString(R.string.activity_register_username_required)
      tilUsername.isErrorEnabled = true
      return false
    }
    return true
  }

  override fun checkEmailNotEmpty(): Boolean {
    if (etEmail.text.isNullOrEmpty()) {
      tilEmail.error = activity.getString(R.string.activity_register_email_required)
      tilEmail.isErrorEnabled = true
      return false
    }
    return true
  }

  override fun checkPasswordNotEmpty(): Boolean {
    if (etPassword.text.isNullOrEmpty()) {
      tilPassword.error = activity.getString(R.string.activity_register_password_required)
      tilPassword.isErrorEnabled = true
      return false
    }
    return true
  }

  override fun showRegisterLoader(show: Boolean) {
    registerLoader.visibility = if (show) View.VISIBLE else View.GONE
  }

  override fun startLoginActivity() {
    activity.startActivity(LandingActivity.getIntent(activity))
    activity.finish()
  }

  override fun startMainActivity() {
    activity.startActivity(MainActivity.getIntent(activity))
    activity.finish()
  }
}