package xyz.ruoxue.opengl.ui.fragment.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.fragment.BasicFragment
import xyz.ruoxue.opengl.ui.presenter.home.MsgPresenter
import xyz.ruoxue.opengl.ui.view.home.IMsgView

/**
 * A simple [Fragment] subclass.
 */
class MsgFragment : BasicFragment(), IMsgView {
    private var lvMsg: ListView? = null
    private var msgPresenter: MsgPresenter? = null


    override fun initData() {
        lvMsg = activity.findViewById(R.id.lv_msg) as  ListView
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
