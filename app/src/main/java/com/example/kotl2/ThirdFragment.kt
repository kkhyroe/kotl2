package com.example.kotl2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class ThirdFragment : Fragment() {
    private lateinit var comm: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        comm = requireActivity() as Communicator
        requireActivity().findViewById<Button>(R.id.button3).visibility = View.VISIBLE

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            comm.passData("+", 3)
        }

        view.findViewById<Button>(R.id.button6).setOnClickListener {
            comm.passData("*", 3)
        }

        view.findViewById<Button>(R.id.button7).setOnClickListener {
            comm.passData("-", 3)
        }

        view.findViewById<Button>(R.id.button8).setOnClickListener {
            comm.passData("/", 3)
        }

        view.findViewById<Button>(R.id.button9).setOnClickListener {
            comm.passData("%", 3)
        }

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }

    override fun onDestroy() {
        requireActivity().findViewById<Button>(R.id.button3).visibility = View.INVISIBLE

        super.onDestroy()
    }
}