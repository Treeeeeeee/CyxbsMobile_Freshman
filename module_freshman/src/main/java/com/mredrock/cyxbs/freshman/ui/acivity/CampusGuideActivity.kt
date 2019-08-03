package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.mredrock.cyxbs.common.ui.BaseFragment
import androidx.databinding.DataBindingUtil
import com.mredrock.cyxbs.freshman.ui.fragment.CanteenFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DemystifyFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DormitoryFragment
import com.mredrock.cyxbs.freshman.ui.fragment.ExpressDeliveryFragment
import kotlinx.android.synthetic.main.freshman_activity_campus_guide.*
import com.mredrock.cyxbs.freshman.data.ViewModel.CampusGuideViewModel
import com.mredrock.cyxbs.freshman.databinding.FreshmanActivityCampusGuideBinding


class CampusGuideActivity : BaseViewModelActivity<CampusGuideViewModel>()  {
    override val viewModelClass: Class<CampusGuideViewModel> = CampusGuideViewModel::class.java
//        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val isFragmentActivity: Boolean = true
    //To change initializer of created properties use File | Settings | File Templates.
    lateinit var binding : FreshmanActivityCampusGuideBinding
    var canteenFragment: CanteenFragment? = null
    var demystifyFragment: DemystifyFragment? = null
    var dormitoryFragment: DormitoryFragment? = null
    var expressDeliveryFragment: ExpressDeliveryFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_campus_guide)

        binding = DataBindingUtil.setContentView(this,R.layout.freshman_activity_campus_guide)
        binding.activity = this
        canteenFragment = CanteenFragment()
    }



    //处理Tab的点击事件
    fun onClick(id:Int) {
        //先将四个ImageButton置为灰色
        resetImgs()
        when (id) {
            R.id.tv_tab_dormitories -> selectTab(0)
            R.id.tv_tab_canteen -> selectTab(1)
            R.id.tv_tab_express_delivery -> selectTab(2)
            R.id.tv_tab_demystify -> selectTab(3)
        }
    }

    //进行选中Tab的处理
    private fun selectTab(i: Int) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        hideFragments(transaction)
        fun clickLogic(tab:TextView,fragment:BaseFragment?,initFragment:()->Unit) {
            tab.setTextColor(0xff4b72f)
            if (fragment == null) {
                initFragment()
            } else {
                transaction.show(fragment)
            }
        }
        when (i) {
            //当选中点击的是微信的Tab时
            0 -> {
                clickLogic(tv_tab_canteen,canteenFragment){
                    canteenFragment = CanteenFragment()
                    transaction.add(R.id.frame_layout_fragment_container_campus_guide,canteenFragment as CanteenFragment)
                }
            }
            1 -> {
                clickLogic(tv_tab_dormitories,dormitoryFragment){
                    dormitoryFragment = DormitoryFragment()
                    transaction.add(R.id.frame_layout_fragment_container_campus_guide,dormitoryFragment as DormitoryFragment)
                }
            }
            2 -> {
                clickLogic(tv_tab_canteen,expressDeliveryFragment){
                    expressDeliveryFragment = ExpressDeliveryFragment()
                    transaction.add(R.id.frame_layout_fragment_container_campus_guide,expressDeliveryFragment as ExpressDeliveryFragment)
                }
            }
            3 -> {
                clickLogic(tv_tab_canteen,demystifyFragment){
                    demystifyFragment = DemystifyFragment()
                    transaction.add(R.id.frame_layout_fragment_container_campus_guide,demystifyFragment as DemystifyFragment)
                }
            }
        }
        //不要忘记提交事务
        transaction.commit()
    }

    //将四个的Fragment隐藏
    private fun hideFragments(transaction: FragmentTransaction) {
        canteenFragment?.let {
            transaction.hide(it)
        }
        dormitoryFragment?.let {
            transaction.hide(it)
        }
        expressDeliveryFragment?.let {
            transaction.hide(it)
        }
        demystifyFragment?.let {
            transaction.hide(it)
        }
    }

    //将四个ImageButton置为灰色
    private fun resetImgs() {
        tv_tab_canteen.setTextColor(0x00000000)
        tv_tab_demystify.setTextColor(0x00000000)
        tv_tab_dormitories.setTextColor(0x00000000)
        tv_tab_express_delivery.setTextColor(0x00000000)
    }

}
