package xyz.ruoxue.opengl.ui.fragment.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ExpandableListView
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.entities.MsgMode
import xyz.ruoxue.opengl.ui.adapter.listAdapter.MsgAdapter
import xyz.ruoxue.opengl.ui.fragment.BasicFragment
import xyz.ruoxue.opengl.ui.presenter.home.MsgPresenter
import xyz.ruoxue.opengl.ui.view.home.IMsgView
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class MsgFragment : BasicFragment(), IMsgView {
    private var elv_msg: ExpandableListView? = null
    private var msgPresenter: MsgPresenter? = null
    private var adapter: MsgAdapter<String>? = null
    private var list: ArrayList<MsgMode<String>>? = ArrayList<MsgMode<String>>()

    override fun initData() {
        elv_msg = activity.findViewById(R.id.elv_msg) as  ExpandableListView
        for (i in 1..10) {

            var m = MsgMode<String>()

            m.group = i.toString()
            var l = ArrayList<String>()
            l.add(i.toString())
            m.list = l
            list?.add(m)
            list?.add(m)
            list?.add(m)

        }


        if (adapter == null) {
            adapter = MsgAdapter(activity, list)
            elv_msg?.setAdapter(adapter)

        } else {
            adapter!!.notifyDataSetChanged()
        }


        elv_msg!!.setOnScrollListener(object :AbsListView.OnScrollListener{
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {

            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }
        })

    }

    override fun initEvent() {

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_msg, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        msgPresenter = MsgPresenter(this)

    }


}
