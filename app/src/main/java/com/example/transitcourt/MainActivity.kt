package com.example.transitcourt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transitcourt.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            cardView1.setOnClickListener {
                val intent = Intent(this@MainActivity, TransitActivity::class.java)
                intent.putExtra("layoutResId", R.layout.activity_transit)
                startActivity(intent)
            }

            cardView2.setOnClickListener {
                val intent = Intent(this@MainActivity, ParkingActivity::class.java)
                intent.putExtra("layoutResId", R.layout.activity_parking)
                startActivity(intent)
            }

            cardView3.setOnClickListener {
                val intent = Intent(this@MainActivity, HistoryActivity::class.java)
                intent.putExtra("layoutResId", R.layout.activity_history)
                startActivity(intent)
            }

            cardView4.setOnClickListener {
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                intent.putExtra("layoutResId", R.layout.activity_settings)
                startActivity(intent)
            }
        }
    }
}
