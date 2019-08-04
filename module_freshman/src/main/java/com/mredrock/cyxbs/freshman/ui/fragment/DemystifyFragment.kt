package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import org.greenrobot.eventbus.Subscribe

/**
 * Created by Tree on 2019/8/3 10:15
 */
class DemystifyFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_demystify, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    @Subscribe(sticky = true)
    fun onBeanReady(bean:CampusGuideDemystifyBean){

    }
}
