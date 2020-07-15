package com.cengiztoru.samplenavigationexample.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

open class BaseFragment : Fragment() {

    fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
}