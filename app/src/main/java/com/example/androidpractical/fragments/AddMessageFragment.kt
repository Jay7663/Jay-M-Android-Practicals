package com.example.androidpractical.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidpractical.R
import com.example.androidpractical.utils.MyViewModel

class AddMessageFragment : Fragment() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_message, container, false)

        val btnSendText: Button = view.findViewById(R.id.btnSendText)
        val etText: EditText = view.findViewById(R.id.etText)
        val tvTextData: TextView = view.findViewById(R.id.tvTextData)

        viewModel.getText().observe(viewLifecycleOwner, {
            tvTextData.text = it
        })

        btnSendText.setOnClickListener {
            viewModel.setText(etText.text.toString())
        }
        return view
    }
}