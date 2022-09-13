package com.example.finalassignment2.ui.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalassignment2.R
import com.example.finalassignment2.database.TaskEntry
import com.example.finalassignment2.databinding.FragmentUpdateBinding
import com.example.finalassignment2.viewmodel.TaskViewModel


class UpdateFragment : Fragment() {


    private val viewModel: TaskViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val binding = FragmentUpdateBinding.inflate(inflater)

        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateAddTitle.setText(args.taskEntry.title)
            updateAddCategory.setText(args.taskEntry.category)
            updateAddDescription.setText(args.taskEntry.description)
            updateAddDate.setText(args.taskEntry.date)

            updateAddButton.setOnClickListener{
                if(TextUtils.isEmpty(updateAddTitle.text) || TextUtils.isEmpty(updateAddCategory.text)
                    || TextUtils.isEmpty(updateAddDescription.text) || TextUtils.isEmpty(updateAddDate.text)) {
                    Toast.makeText(
                        requireContext(),
                        "one or more fields are empty !",
                        Toast.LENGTH_LONG
                    ).show()
                  return@setOnClickListener
                }

                val  task_str  = updateAddTitle.text
                val  task_str2 = updateAddCategory.text
                val task_str3 = updateAddDescription.text
                val task_str4 = updateAddDate.text

                val taskEntry = TaskEntry(
                    args.taskEntry.id,
                    task_str.toString(),
                    task_str2.toString(),
                    task_str3.toString(),
                    task_str4.toString()

                )
              viewModel.update(taskEntry)
                Toast.makeText(
                    requireContext(),
                    "Updated!",
                    Toast.LENGTH_LONG
                ).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)

            }

        }
        return binding.root
        // Inflate the layout for this fragment
    }

}