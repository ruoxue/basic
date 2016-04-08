package xyz.ruoxue.opengl.ui.adapter.listAdapter

import android.widget.BaseAdapter

/**
 * Created by RuoxueYe on 2016/4/5.
 */
abstract class BasicListAdapter<E>(open var data: List<E>) : BaseAdapter() {


    /**
     * How many items are in the data set represented by this Adapter.

     * @return Count of items.
     */
    override fun getCount(): Int {
        return data.size
    }

    /**
     * Get the data item associated with the specified position in the data set.

     * @param position Position of the item whose data we want within the adapter's
     * *                 data set.
     * *
     * @return The data at the specified position.
     */
    override fun getItem(position: Int): Any {
        return data[position]!!
    }

    /**
     * Get the row id associated with the specified position in the list.

     * @param position The position of the item within the adapter's data set whose row id we want.
     * *
     * @return The id of the item at the specified position.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}
