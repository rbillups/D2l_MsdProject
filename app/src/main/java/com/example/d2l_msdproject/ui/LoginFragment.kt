package com.example.d2l_msdproject.ui

import android.content.Context
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import java.net.PasswordAuthentication

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        //Listener for sign in button.
        binding.signInButton.setOnClickListener {
            binding.signInButton.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_loginFragment_to_appMainFragment)
            }
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}