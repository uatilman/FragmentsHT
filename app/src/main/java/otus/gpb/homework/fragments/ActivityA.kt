package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityABinding

class ActivityA : AppCompatActivity() {

    private lateinit var binding: ActivityABinding

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentA = if (savedInstanceState == null) {
            FragmentA.newInstance()
        } else {
            supportFragmentManager.findFragmentByTag("fragmentA") as FragmentA
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_activity_a, fragmentA, "fragmentA")
            .commit()

    }
}