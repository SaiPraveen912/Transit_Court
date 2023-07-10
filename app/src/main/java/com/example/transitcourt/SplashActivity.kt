package com.example.transitcourt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000 // Adjust the duration as needed (in milliseconds)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Start a coroutine to delay the transition to LoginActivity
        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_DELAY)
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel the coroutine when the activity is destroyed to avoid leaks
        coroutineContext.cancel()
    }
}
