package com.template.footballquiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.template.footballquiz.R
import com.template.footballquiz.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        binding.startBtn.setOnClickListener { view: View ->
            if (binding.etName.text!!.isNotEmpty()) {
                val action = TitleFragmentDirections.actionTitleFragmentToGameFragment()
                action.name = binding.etName.text.toString()
                findNavController().navigate(action)
            } else {
                Toast.makeText(context, "Enter your name to start", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}