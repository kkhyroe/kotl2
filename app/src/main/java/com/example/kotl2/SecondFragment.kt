package com.example.kotl2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SecondFragment : Fragment() {
    private lateinit var comm: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        comm = requireActivity() as Communicator
        requireActivity().findViewById<Button>(R.id.button2).visibility = View.VISIBLE

        view.findViewById<Button>(R.id.buttonNext).setOnClickListener {
            val inputEditText = view.findViewById<EditText>(R.id.editTextNumber)
            comm.passData(inputEditText.text.toString(), 2)
        }

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }

    override fun onDestroy() {
        requireActivity().findViewById<Button>(R.id.button2).visibility = View.INVISIBLE

        super.onDestroy()
    }
}