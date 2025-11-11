package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentABBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAB : Fragment() {


    private var _binding: FragmentABBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var color: Int = Color.CYAN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(COLOR_ARG_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.root.setBackgroundColor(color)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_ARG_PARAM, param1)
                }
            }
    }
}