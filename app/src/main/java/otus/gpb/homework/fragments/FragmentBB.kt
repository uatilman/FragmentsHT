package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.databinding.FragmentBBBinding
import otus.gpb.homework.fragments.utils.COLOR_RESULT_BUNDLE_KEY
import otus.gpb.homework.fragments.utils.COLOR_RESULT_KEY

class FragmentBB : Fragment() {
    private var _binding: FragmentBBBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentBBButton?.setOnClickListener {
            setFragmentResult(
                COLOR_RESULT_KEY,
                bundleOf(COLOR_RESULT_BUNDLE_KEY to ColorGenerator.generateColor())
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}