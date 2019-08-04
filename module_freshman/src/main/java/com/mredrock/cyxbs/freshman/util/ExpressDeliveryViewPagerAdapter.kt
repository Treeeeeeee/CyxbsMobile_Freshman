package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_view_pager_express_delivery_page.view.*
import java.math.MathContext

/**
 * Created by Tree on 2019/8/3 11:12
 */
class ExpressDeliveryViewPagerAdapter(val context: Context) : PagerAdapter() {


    val list = listOf("顺丰","韵达","中通","圆通","中通","邮政","菜鸟驿站（校外）","百世")

    private val pagerList = ArrayList<View>()



    init {
        repeat(list.size) {
            pagerList.add(
                View.inflate(
                    context,
                    R.layout.freshman_view_pager_express_delivery_page,
                    null
                )
            )}
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        pagerList[position].ll_express_delivery_container.addView(
            View.inflate(
                context,
                R.layout.freshman_view_pager_page_scroll_view_item_express_delivery,
                null
            )
        )
        container.addView(pagerList[position])
        return pagerList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pagerList[position])
    }

}
