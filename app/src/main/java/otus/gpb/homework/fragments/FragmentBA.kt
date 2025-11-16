package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.databinding.FragmentBABinding
import otus.gpb.homework.fragments.utils.COLOR_RESULT_BUNDLE_KEY_BB_TO_BA
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
        fragmentBB = savedInstanceState
            ?.let {
                parentFragmentManager.getFragment(savedInstanceState, "fragmentBB") as? FragmentBB
            }
            ?: FragmentBB()

        setFragmentResultListener(COLOR_RESULT_KEY_BB_TO_BA) { _, bundle ->
            val color: Int = bundle.getInt(COLOR_RESULT_BUNDLE_KEY_BB_TO_BA)
            binding.root.setBackgroundColor(color)
        }

        binding.fragmentBBButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_b_a_container, fragmentBB, FragmentBB::class.simpleName)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}