package com.example.d2l_msdproject.ui

import android.content.Context
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

            var email = binding.loginEmail.text.toString()
            Log.d("TAG", "Email : $email")
            val userPw = binding.loginPassword.text.toString()

            var user = getFirstThreeLetters(email)
            Log.d("TAG", "UserName password: $user")
            var pwPath = user
            pwPath += "Pw"

            val path = FirebaseDatabase.getInstance().getReference("Login/$pwPath")
            Log.d("TAG", "Path password: $pwPath")

            path.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    //get data
                    var password = snapshot.getValue(Int::class.java)

                    //check pw
                    if (userPw == password.toString()) {


                        // Navigate to appMainFragment if userPw matches password
                        view?.findNavController()
                            ?.navigate(R.id.action_loginFragment_to_appMainFragment)
                    } else {
                        Log.d("TAG", "User password: $userPw")
                        Log.d("TAG", "Actual password: $password")
                        // Show a Toast message if userPw doesn't match password
                        Toast.makeText(context, "Passwords don't match", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled logic here
                }
            })

        }


        return binding.root

    }



    fun getFirstThreeLetters(str: String): String {
        if (str.length >= 3) {
            val firstThree = str.substring(0, 3)
            val firstLetter = firstThree[0].toString()

            // Check if the first letter is not already capitalized
            if (firstLetter != firstLetter.toUpperCase()) {
                // Capitalize the first letter
                return firstThree.replaceFirst(firstLetter, firstLetter.toUpperCase())
            } else {
                return firstThree
            }
        } else {
            return str
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}