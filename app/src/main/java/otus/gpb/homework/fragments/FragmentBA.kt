package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.databinding.FragmentBABinding
import otus.gpb.homework.fragments.utils.COLOR_RESULT_BUNDLE_KEY
import otus.gpb.homework.fragments.utils.COLOR_RESULT_KEY


class FragmentBA : Fragment() {
    private var _binding: FragmentBABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBABinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(COLOR_RESULT_KEY) { _, bundle ->
            val color: Int = bundle.getInt(COLOR_RESULT_BUNDLE_KEY)
            binding.root.setBackgroundColor(color)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}