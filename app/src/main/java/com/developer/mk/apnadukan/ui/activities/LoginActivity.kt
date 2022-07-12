package com.developer.mk.apnadukan.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.developer.mk.apnadukan.R
import com.developer.mk.apnadukan.databinding.ActivityLoginBinding

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

         loginBinding.tvRegister.setOnClickListener {

            // Launch the register screen when the user clicks on the text.
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}