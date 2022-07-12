package com.developer.mk.apnadukan.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.developer.mk.apnadukan.R
import com.developer.mk.apnadukan.databinding.ActivityLoginBinding
import com.developer.mk.apnadukan.databinding.ActivityRegisterBinding

@Suppress("DEPRECATION")
class RegisterActivity : BaseActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupActionBar()
        // END

        // TODO Step 8: Assign a click event to the register button and call the validate function.
        // START
        registerBinding.btnRegister.setOnClickListener {

            validateRegisterDetails()
        }
        // END
    }

    // TODO Step 1: Create a function to set up an action bar.
    // START
    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(registerBinding.toolbarRegisterActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }

        registerBinding.toolbarRegisterActivity.setNavigationOnClickListener { onBackPressed() }
    }
    // END

    // TODO Step 6: Create an function to validate the register account fields.
    // START
    /**
     * A function to validate the entries of a new user.
     */
    private fun validateRegisterDetails(): Boolean {
        return when {
            TextUtils.isEmpty(registerBinding.etFirstName.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_first_name), true)
                false
            }

            TextUtils.isEmpty(registerBinding.etLastName.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_last_name), true)
                false
            }

            TextUtils.isEmpty(registerBinding.etEmail.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(registerBinding.etPassword.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

            TextUtils.isEmpty(registerBinding.etConfirmPassword.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            registerBinding.etPassword.text.toString().trim { it <= ' ' }
                    != registerBinding.etConfirmPassword.text.toString()
                .trim { it <= ' ' } -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch), true)
                false
            }
            !registerBinding.cbTermsAndCondition.isChecked -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_agree_terms_and_condition), true)
                false
            }
            else -> {
                showErrorSnackBar("Your details are valid.", false)
                true
            }
        }
    }

}