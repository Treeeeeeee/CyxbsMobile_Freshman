package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerPageScrollViewItemExpressDeliveryBinding
import com.mredrock.cyxbs.freshman.updata.IMAGE_BASE_URI
import kotlinx.android.synthetic.main.freshman_view_pager_express_delivery_page.view.*
import java.math.MathContext

/**
 * Created by Tree on 2019/8/3 11:12
 */
class ExpressDeliveryViewPagerAdapter(val context: Context, var bean: CampusGuideExpressDeliveryBean) : PagerAdapter() {



    private val pagerList = ArrayList<View>()


    init {
        for (msg in bean.text) {
            val view = View.inflate(
                context,
                R.layout.freshman_view_pager_express_delivery_page,
                null
            )
            val bind =
                DataBindingUtil.bind<com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerExpressDeliveryPageBinding>(
                    view
                )
            bind?.text = msg.name
            pagerList.add(
                view
            )
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return bean.text[position].name
    }

    override fun getCount(): Int {
        return bean.text.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        if (pagerList[position].ll_express_delivery_container.getChildAt(0) == null) {
            for (msg in bean.text[position].message) {
                val view = View.inflate(
                    context,
                    R.layout.freshman_view_pager_page_scroll_view_item_express_delivery,
                    null
                )
                pagerList[position].ll_express_delivery_container.addView(view)
                val bind = DataBindingUtil.bind<FreshmanViewPagerPageScrollViewItemExpressDeliveryBinding>(view)
                bind?.bean = msg.apply {
                    photo = IMAGE_BASE_URI+ photo
                }
            }
        }

        container.addView(pagerList[position])
        return pagerList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pagerList[position])
    }

}
