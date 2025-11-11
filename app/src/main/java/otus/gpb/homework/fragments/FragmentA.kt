package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentABinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var fragmentAA: FragmentAA

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentAA = if (savedInstanceState == null) {
            FragmentAA.newInstance(ColorGenerator.generateColor())
        } else {
            childFragmentManager.findFragmentByTag("fragmentA") as FragmentAA
        }
        with(binding) {
            fragmentAAButton.setOnClickListener {
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container, fragmentAA)
                    .addToBackStack("fragmentA")
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentA()
    }
}