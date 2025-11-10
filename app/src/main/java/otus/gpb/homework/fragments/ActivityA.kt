package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    private lateinit var activityA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        if (savedInstanceState == null) {
            activityA = FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_a, activityA, "fragmentA")
                .commit()
        }

    }
}