package io.robothouse.androidboilerplate.feature.landing

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.robothouse.androidboilerplate.R
import io.robothouse.androidboilerplate.feature.BaseScreen
import io.robothouse.androidboilerplate.feature.main.MainActivity
import io.robothouse.androidboilerplate.feature.register.RegisterActivity
import io.robothouse.androidboilerplate.util.TextWatcher

class LandingScreenImpl(
  activity: LandingActivity
) : LandingScreen, BaseScreen(activity) {

  private val etEmail: TextInputEditText = activity.findViewById(R.id.et_email)
  private val tilEmail: TextInputLayout = activity.findViewById(R.id.til_email)
  private val etPassword: TextInputEditText = activity.findViewById(R.id.et_password)
  private val tilPassword: TextInputLayout = activity.findViewById(R.id.til_password)
  private val login: TextView = activity.findViewById(R.id.btn_login)
  private val register: TextView = activity.findViewById(R.id.tv_signup)
  private val loginLoader: LinearLayout = activity.findViewById(R.id.login_progress_layout)

  override fun registerEvents(presenter: LandingPresenter) {

    login.setOnClickListener {
      presenter.onLoginClick(etEmail.text.toString(), etPassword.text.toString())
    }
    register.setOnClickListener {
      presenter.onRegisterClick()
    }

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

  override fun showLoginLoader(show: Boolean) {
    loginLoader.visibility = if (show) View.VISIBLE else View.GONE
  }

  override fun checkEmailNotEmpty(): Boolean {
    if (etEmail.text.isNullOrEmpty()) {
      tilEmail.error = activity.getString(R.string.activity_landing_email_required)
      tilEmail.isErrorEnabled = true
      return false
    }
    return true
  }

  override fun checkPasswordNotEmpty(): Boolean {
    if (etPassword.text.isNullOrEmpty()) {
      tilPassword.error = activity.getString(R.string.activity_landing_password_required)
      tilPassword.isErrorEnabled = true
      return false
    }
    return true
  }

  override fun startRegisterActivity() {
    activity.startActivity(RegisterActivity.getIntent(activity))
    activity.finish()
  }

  override fun startMainActivity() {
    activity.startActivity(MainActivity.getIntent(activity))
    activity.finish()
  }
}