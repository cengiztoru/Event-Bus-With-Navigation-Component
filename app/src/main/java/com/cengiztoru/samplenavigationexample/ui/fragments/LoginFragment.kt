package com.cengiztoru.samplenavigationexample.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cengiztoru.samplenavigationexample.R
import com.cengiztoru.samplenavigationexample.data.User
import kotlinx.android.synthetic.main.fragment_login.*
import org.greenrobot.eventbus.EventBus

class LoginFragment : BaseFragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnSignup).setOnClickListener(this)
//        btnLogin.setOnClickListener(this)
//        btnSignup.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnLogin -> {

                if (!TextUtils.isEmpty(etMail.text.toString()) && !TextUtils.isEmpty(etPassword.text.toString())) {
                    val user = getUserData()
                    EventBus.getDefault().postSticky(user)
                    navController.navigate(R.id.action_loginFragment_to_homeFragment)

                } else {
                    showToast("PLEASE ENTER YOUR EMAIL AND PASSWORD")
                }
            }

            R.id.btnSignup -> {
                navController.navigate(R.id.action_loginFragment_to_signupFragment)
            }
        }
    }

    private fun getUserData() = User(etMail.text.toString(), "Cengiz", "TORU")

}