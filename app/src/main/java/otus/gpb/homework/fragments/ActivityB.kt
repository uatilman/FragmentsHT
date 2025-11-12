package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB

    private val isTablet by lazy { resources.getBoolean(R.bool.is_tablet) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (isTablet) {
            fragmentBA = savedInstanceState
                ?.let { supportFragmentManager.findFragmentByTag(FragmentBA::class.simpleName) as? FragmentBA }
                ?: FragmentBA()

            fragmentBB = savedInstanceState
                ?.let { supportFragmentManager.findFragmentByTag(FragmentBB::class.simpleName) as? FragmentBB }
                ?: FragmentBB()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_a_container, fragmentBA, FragmentBA::class.simpleName)
                .replace(R.id.fragment_b_b_container, fragmentBB, FragmentBB::class.simpleName)
                .commit()
        } else {
            fragmentBA = savedInstanceState
                ?.let { supportFragmentManager.findFragmentByTag(FragmentBA::class.simpleName) as? FragmentBA }
                ?: FragmentBA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_a_container, fragmentBA, FragmentBA::class.simpleName)
                .commit()
        }


    }


}