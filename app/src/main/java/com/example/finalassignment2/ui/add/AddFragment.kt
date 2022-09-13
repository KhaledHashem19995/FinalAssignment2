package com.example.finalassignment2.ui.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalassignment2.R
import com.example.finalassignment2.database.TaskEntry
import com.example.finalassignment2.databinding.FragmentAddBinding
import com.example.finalassignment2.viewmodel.TaskViewModel

class AddFragment : Fragment() {

private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentAddBinding.inflate(inflater)

        binding.apply {
            addButton.setOnClickListener{
                if(TextUtils.isEmpty(addTitle.text) || TextUtils.isEmpty(addCategory.text)
                            || TextUtils.isEmpty(addDescription.text) || TextUtils.isEmpty(addDate.text)){
                         Toast.makeText(requireContext(), "one or more fields are empty !", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                    }
                  val title_str = addTitle.text.toString()
                  val category_str = addCategory.text.toString()
                  val description_str = addDescription.text.toString()
                  val date_str = addDate.text.toString()

                val taskEntry = TaskEntry(0,
                    title_str,category_str,description_str,date_str

                )

                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)

            }
        }



return binding.root



}
}