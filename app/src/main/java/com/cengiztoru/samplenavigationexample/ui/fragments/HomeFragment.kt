package com.cengiztoru.samplenavigationexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cengiztoru.samplenavigationexample.R
import com.cengiztoru.samplenavigationexample.data.User
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.Subscribe

class HomeFragment : BaseEventBusFragment() {

    lateinit var user: User
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

    @Subscribe(sticky = true)
    override fun onUserLogged(user: User) {
        this.user = user
        showToast("HOME FRAGMENT" + this.user.email)
        message.text = "Welcome ${user.name} ${user.surname} \n ${user.email}"

    }

}