package xyz.ruoxue.opengl.ui.activity.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.KeyEvent
import com.pawegio.kandroid.find
import com.pawegio.kandroid.toast
import me.relex.circleindicator.CircleIndicator
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.activity.BasicActivity
import xyz.ruoxue.opengl.ui.adapter.fragmentAdapter.BasicFragementAdapter
import xyz.ruoxue.opengl.ui.fragment.BasicFragment
import xyz.ruoxue.opengl.ui.fragment.home.HomeFragment
import xyz.ruoxue.opengl.ui.fragment.home.MeFragment
import xyz.ruoxue.opengl.ui.fragment.home.MsgFragment
import xyz.ruoxue.opengl.ui.presenter.home.HomePresenter
import xyz.ruoxue.opengl.ui.view.home.HomeViewI
import java.util.*


class HomeActivity : BasicActivity(), HomeViewI {


    /*
     *view  init
     */
    private val ci: CircleIndicator by lazy { find<CircleIndicator>(R.id.ci) }
    private val mVpHome: ViewPager by lazy { find<ViewPager>(R.id.m_vp_home) }
    private val mTabHome: TabLayout by lazy { find<TabLayout>(R.id.m_tab_home) }
    private var homePresent: HomePresenter? = null

    private var homeAdapter: BasicFragementAdapter? = null
    private val fs = ArrayList<BasicFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_home)


        homePresent = HomePresenter(this)
    }


    override fun initData() {

        setCustomeTitle(R.string.home)
        fs.add(HomeFragment());
        fs.add(MsgFragment())
        fs.add(MeFragment())

        mVpHome.offscreenPageLimit = fs.size
        if (homeAdapter == null) {
            homeAdapter = BasicFragementAdapter(supportFragmentManager, fs)
            mVpHome.adapter = homeAdapter
        } else {
            homeAdapter!!.notifyDataSetChanged()
        }
        mTabHome.setupWithViewPager(mVpHome)
        ci.setViewPager(mVpHome)
        mTabHome.removeAllTabs()
        mTabHome.addTab(mTabHome.newTab().setText(R.string.home).setIcon(R.drawable.bg_home), 0)
        mTabHome.addTab(mTabHome.newTab().setText(R.string.msg).setIcon(R.drawable.bg_home), 1)
        mTabHome.addTab(mTabHome.newTab().setText(R.string.me).setIcon(R.drawable.bg_home), 2)

    }


    /**
     * 初始化事件
     */
    override fun initEvent() {

        mVpHome.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                homePresent!!.title(position, supportActionBar!!, this@HomeActivity)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


    }

    override fun initErr() {
        toast("加载err ing...........")
    }

    /*主页返回键
     *
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event?.repeatCount == 0) {
            close()
            return true;
        }
        return super.onKeyDown(keyCode, event)
    }

}
