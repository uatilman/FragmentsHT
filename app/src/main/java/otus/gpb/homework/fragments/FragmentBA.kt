package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.databinding.FragmentBABinding
import otus.gpb.homework.fragments.utils.COLOR_RESULT_BUNDLE_KEY_BA_TO_BB
import otus.gpb.homework.fragments.utils.COLOR_RESULT_BUNDLE_KEY_BB_TO_BA
import otus.gpb.homework.fragments.utils.COLOR_RESULT_KEY_BA_TO_BB
import otus.gpb.homework.fragments.utils.COLOR_RESULT_KEY_BB_TO_BA


class FragmentBA : Fragment() {
    private var _binding: FragmentBABinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentBB: FragmentBB

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
        fragmentBB = if (savedInstanceState == null) {
            FragmentBB()
        } else {
            childFragmentManager.getFragment(savedInstanceState, "fragmentBB") as FragmentBB
        }
        setFragmentResultListener(COLOR_RESULT_KEY_BB_TO_BA) { _, bundle ->
            val color: Int = bundle.getInt(COLOR_RESULT_BUNDLE_KEY_BB_TO_BA)
            binding.root.setBackgroundColor(color)
        }

        binding.fragmentBBButton?.setOnClickListener {
            setFragmentResult(
                COLOR_RESULT_KEY_BA_TO_BB,
                bundleOf(COLOR_RESULT_BUNDLE_KEY_BA_TO_BB to ColorGenerator.generateColor())
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_a_container, fragmentBB)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}