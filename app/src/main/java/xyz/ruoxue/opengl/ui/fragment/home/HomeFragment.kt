package xyz.ruoxue.opengl.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.socks.library.KLog
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.adapter.listAdapter.Homeadapter
import xyz.ruoxue.opengl.ui.fragment.BasicFragment
import xyz.ruoxue.opengl.ui.presenter.home.HomeFragmentPresenter
import xyz.ruoxue.opengl.ui.view.home.HomeFragementViewI
import java.util.*

/**
 * Created by RuoxueYe on 2016/4/5.
 */
open class HomeFragment : BasicFragment(), HomeFragementViewI {

    init {
        KLog.i("ruoxue","init")
    }




    private var lvHome: ListView? = null

    private var lists: ArrayList<String>? = null

    private var adapter: Homeadapter? = null


    override fun initEvent() {
        KLog.i("ruoxue","initEvent")
        lvHome!!.setOnItemClickListener { adapterView, view, position, id -> homeFragmentPresenter!!.tvHomeClick(position, this@HomeFragment) }


    }

    override fun initData() {
        KLog.i("ruoxue","initData")
        lvHome = activity.findViewById(R.id.lv_home) as ListView


        if (adapter == null) {
            adapter = Homeadapter(lists!!, context)
            lvHome?.adapter = adapter
        } else {
            adapter!!.notifyDataSetChanged()
        }
        lvHome!!.setSelection(0)

    }


    private var homeFragmentPresenter: HomeFragmentPresenter? = null



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        KLog.i("ruoxue","onCreateView")

        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lists = ArrayList<String>();
        for (i in 1..10) {
            lists!!.add(1.toString() + i)
            lists!!.add(1.toString() + i)
            lists!!.add(1.toString() + i)
        }


        KLog.i("ruoxue","onViewCreated")

        homeFragmentPresenter = HomeFragmentPresenter(this)

    }


}