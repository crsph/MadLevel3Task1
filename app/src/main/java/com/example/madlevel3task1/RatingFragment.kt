package com.example.madlevel3task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_rate.*

class RatingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToSummary.setOnClickListener {
            navigateToSummary()
        }

        showRandomAssessableGame()
    }

    private fun navigateToSummary() {

        val args = Bundle()
        args.putFloat(ARG_GAME_RATING, rbGame.rating)
        args.putString(ARG_GAME_NAME, tvGameName.text.toString())

        findNavController().navigate(R.id.action_ratingFragment_to_summaryFragment, args)
    }

    private fun showRandomAssessableGame() {
        val randomGame = listOf(
            "League of Legends", "Stardew Valley",
            "Genshin Impact", "Among us", "Terraria", "Mincraft",
            "Blade & Soul"
        ).random()

        tvGameName.text = randomGame
    }
}