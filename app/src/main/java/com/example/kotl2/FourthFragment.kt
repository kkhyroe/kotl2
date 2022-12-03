package com.example.kotl2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FourthFragment : Fragment() {
    private var inputText: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)
        requireActivity().findViewById<Button>(R.id.button4).visibility = View.VISIBLE

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            requireActivity().onBackPressed()
        }

        inputText = arguments?.getString("result")

        val outputTextView = view.findViewById<TextView>(R.id.resultView)
        outputTextView.text = inputText

        return view
    }

    override fun onDestroy() {
        requireActivity().findViewById<Button>(R.id.button4).visibility = View.INVISIBLE

        super.onDestroy()
    }
}