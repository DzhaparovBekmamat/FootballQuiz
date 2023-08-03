package com.template.footballquiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.template.footballquiz.R
import com.template.footballquiz.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
    lateinit var binding: FragmentScoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        val scoreArgs by navArgs<ScoreFragmentArgs>()
        binding.displayResult.text =
            "${scoreArgs.name}! You have scored ${scoreArgs.score} points out of 20"
        binding.playAgain.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            view?.findNavController()?.navigate(R.id.action_scoreFragment_to_titleFragment)
        }
        return binding.root
    }
}