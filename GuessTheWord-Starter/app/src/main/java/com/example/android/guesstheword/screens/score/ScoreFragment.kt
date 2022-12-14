/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.score

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.ScoreFragmentBinding
import com.example.android.guesstheword.screens.game.GameViewModel
import kotlinx.android.synthetic.main.main_activity.*

/**
 * Fragment where the final score is shown, after the game is over
 */
class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel

    private val args: ScoreFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.score_fragment,
                container,
                false
        )

        Log.i("ScoreViewModel", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        viewModel.score = args.score

        binding.scoreText.text = viewModel.score.toString()
        binding.playAgainButton.setOnClickListener { onPlayAgain() }

        return binding.root
    }

    fun onPlayAgain() {
        val action = ScoreFragmentDirections.actionRestart()
        NavHostFragment.findNavController(this).navigate(action)
    }

}
