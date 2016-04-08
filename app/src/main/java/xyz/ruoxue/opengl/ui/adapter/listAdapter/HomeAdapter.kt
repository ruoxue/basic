package xyz.ruoxue.opengl.ui.adapter.listAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import xyz.ruoxue.opengl.R

/**
 * Created by RuoxueYe on 2016/4/6.
 */
class Homeadapter(override var data: List<String>, var context: Context) : BasicListAdapter<String>(data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holde: Holde

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
            holde = Holde()
            holde.textView = convertView!!.findViewById(R.id.tv_home) as TextView
            convertView.tag = holde
        } else {
            holde = convertView.tag as Holde
        }

        holde.textView!!.text = data[position]


        return convertView
    }

    internal inner class Holde {
        var textView: TextView ?? = null
    }
}