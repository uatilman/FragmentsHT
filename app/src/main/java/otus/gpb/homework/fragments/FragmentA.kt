package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
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

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val backStackEntryCount = parentFragmentManager.backStackEntryCount
                Toast.makeText(
                    context,
                    "FragmentA back stack entry count: $backStackEntryCount",
                    Toast.LENGTH_SHORT
                ).show()
                if (backStackEntryCount > 0) {
                    parentFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

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
            parentFragmentManager.findFragmentByTag("fragmentAA") as FragmentAA
        }
        with(binding) {
            fragmentAAButton.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container, fragmentAA, "fragmentAA")
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