package com.example.navcomponent.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.navcomponent.R
import com.example.navcomponent.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentContext = view.context
        listeners()
    }

    private fun listeners() {
        binding.buttonSubmit.setOnClickListener {
            val name = binding.editTextTextName.text.toString()
            val lastName = binding.editTextTextLastName.text.toString()

            if (name.isNotEmpty() && lastName.isNotEmpty()) {
                val bundle = bundleOf(USER_DATA to "$name $lastName")
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            } else {
                Toast.makeText(fragmentContext, "Empty fields", Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object {
        const val USER_DATA = "userData"
    }
}