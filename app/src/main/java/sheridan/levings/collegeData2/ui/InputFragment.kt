package sheridan.levings.collegeData2.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sheridan.levings.collegeData2.R
import sheridan.levings.collegeData2.databinding.FragmentInputBinding
import sheridan.levings.collegeData2.model.StudentInfo

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        binding.btnSubmit.setOnClickListener { showOutput() }
        return binding.root
    }

    private fun showOutput() {
        val studentName = binding.txtStudent.text.toString().trim()
        if (studentName.isEmpty()) {
            val required = getString(R.string.required)
            binding.txtStudent.error = required
            Toast.makeText(context, required, Toast.LENGTH_LONG).show()
        } else {
            val programType =
                when (binding.radioGroup.checkedRadioButtonId) {
                    R.id.diploma -> getString(R.string.diploma)
                    R.id.degree -> getString(R.string.degree)
                    else -> getString(R.string.undefined)
                }
            val studentInfo = StudentInfo(studentName, programType)
            val action = InputFragmentDirections.actionInputToOutput(studentInfo)
            findNavController().navigate(action)
        }
    }
}