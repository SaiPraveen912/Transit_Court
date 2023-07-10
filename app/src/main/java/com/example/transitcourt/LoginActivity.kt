package com.example.transitcourt

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.transitcourt.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonLogin = binding.btnLogin
        buttonLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            login(username, password)
        }

        binding.showPassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Show password
                binding.etPassword.transformationMethod = null
            } else {
                // Hide password
                binding.etPassword.transformationMethod = PasswordTransformationMethod()
            }
        }
    }

    private fun login(username: String, password: String) {
        // Perform login logic here
        if (username == "admin" && password == "password") {
            // Successful login
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Failed login
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

}


