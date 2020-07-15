package com.cengiztoru.samplenavigationexample.ui.fragments

import com.cengiztoru.samplenavigationexample.data.User
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

open class BaseEventBusFragment : BaseFragment() {
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(sticky = true)
    open fun onUserLogged(user: User) {
        showToast("BASEFRAGMENT" + this.javaClass.name)
    }
}
