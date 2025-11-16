package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentABinding


class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null

    private val binding get() = _binding!!

    private lateinit var fragmentAA: FragmentAA

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
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
            childFragmentManager.findFragmentByTag("fragmentAA") as FragmentAA
        }
        with(binding) {
            fragmentAAButton.setOnClickListener {
                childFragmentManager.beginTransaction()
                    .replace(fragmentAContainer.id, fragmentAA, "fragmentAA")
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