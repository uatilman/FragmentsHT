package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.databinding.FragmentBBBinding
import otus.gpb.homework.fragments.utils.COLOR_RESULT_BUNDLE_KEY_BB_TO_BA
import otus.gpb.homework.fragments.utils.COLOR_RESULT_KEY_BB_TO_BA

class FragmentBB : Fragment() {
    private var _binding: FragmentBBBinding? = null

    private val binding get() = _binding!!

    private lateinit var fragmentBA: FragmentBA

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
        fragmentBA = savedInstanceState
            ?.let {
                parentFragmentManager.getFragment(savedInstanceState, "fragmentBA") as? FragmentBA
            }
            ?: FragmentBA()

        binding.fragmentBBButton.setOnClickListener {
            setFragmentResult(
                COLOR_RESULT_KEY_BB_TO_BA,
                bundleOf(COLOR_RESULT_BUNDLE_KEY_BB_TO_BA to ColorGenerator.generateColor())
            )
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_b_a_container, fragmentBA, FragmentBA::class.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}