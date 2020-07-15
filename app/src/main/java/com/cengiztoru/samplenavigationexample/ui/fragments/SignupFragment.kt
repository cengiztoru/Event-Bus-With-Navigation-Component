package com.cengiztoru.samplenavigationexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cengiztoru.samplenavigationexample.R

class SignupFragment : BaseFragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnSignup).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnReturnLogin).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnSignup -> {
                //send user data to remote etc.
                // ...
                returnLoginScreen()
            }
            R.id.btnReturnLogin -> {
                returnLoginScreen()
            }
        }
    }

    private fun returnLoginScreen() {

        navController.popBackStack()

//        activity!!.onBackPressed()
    }

}