package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentAABinding

const val COLOR_ARG_PARAM = "color"

class FragmentAA : Fragment() {

    private var _binding: FragmentAABinding? = null

    private val binding get() = _binding!!

    private lateinit var fragmentAB: FragmentAB

    private var color: Int = Color.CYAN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(COLOR_ARG_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAABinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.root.setBackgroundColor(color)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentAB = if (savedInstanceState == null) {
            FragmentAB.newInstance(ColorGenerator.generateColor())
        } else {
            parentFragmentManager.findFragmentByTag("fragmentAB") as FragmentAB
        }
        with(binding) {
            fragmentABButton.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(fragmentAAContainer.id, fragmentAB, "fragmentAB")
                    .addToBackStack("fragmentA").commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) = FragmentAA().apply {
            arguments = Bundle().apply {
                putInt(COLOR_ARG_PARAM, param1)
            }
        }
    }
}