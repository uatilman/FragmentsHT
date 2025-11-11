package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        if (savedInstanceState == null) {
            fragmentA = FragmentA.newInstance()
        } else {
            fragmentA = supportFragmentManager.findFragmentByTag("fragmentA") as FragmentA
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_activity_a, fragmentA, "fragmentA")
            .addToBackStack("fragmentA")
            .commit()

    }
}