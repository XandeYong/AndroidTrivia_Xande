package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.android.guesstheword.screens.game.GameFragment
import com.example.android.guesstheword.screens.game.GameFragmentDirections

class ScoreViewModel: ViewModel() {

    var score = 0

    init {
        Log.i("ScoreViewModel", "ScoreViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ScoreViewModel", "ScoreViewModel has been destroyed!")
    }

}