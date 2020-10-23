package sheridan.levings.collegeData2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import sheridan.levings.collegeData2.databinding.FragmentOutputBinding

class outputFragment : Fragment() {

    private val safeArgs: outputFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOutputBinding.inflate(inflater, container, false)

        with(safeArgs.studentInfo){
            binding.nameOutput.text = studentName
            binding.programOutput.text = programType
        }
        binding.btnBack.setOnClickListener { showInput() }
        return binding.root
    }

    private fun showInput() {
        val action = outputFragmentDirections.actionOutputToInput()
        findNavController().navigate(action)
    }

}