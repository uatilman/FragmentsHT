package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityAButton.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }
        binding.activityBButton.setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }


    }
}