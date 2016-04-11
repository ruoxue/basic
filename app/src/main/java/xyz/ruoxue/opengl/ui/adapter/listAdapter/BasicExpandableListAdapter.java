package xyz.ruoxue.opengl.ui.adapter.listAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;
import java.util.Map;

import xyz.ruoxue.opengl.entities.MsgMode;

// +----------------------------------------------------------------------
//            -------------------------
//           /   / ----------------\  \
//          /   /             \  \
//         /   /              /  /
//        /   /    /-------------- /  /
//       /   /    /-------------------\  \
//      /   /                   \  \
//     /   /                     \  \
//    /   /                      /  /
//   /   /      /----------------------- /  /
//  /-----/      /---------------------------/
// +----------------------------------------------------------------------
// | Copyright (c) 2016 http://baimifan.cn All rights reserved.
// +----------------------------------------------------------------------
// | Author: // +----------------------------------------------------------------------
// +----------------------------------------------------------------------
//            -------------------------
//           /   / ----------------\  \
//          /   /             \  \
//         /   /              /  /
//        /   /    /-------------- /  /
//       /   /    /-------------------\  \
//      /   /                   \  \
//     /   /                     \  \
//    /   /                      /  /
//   /   /      /----------------------- /  /
//  /-----/      /---------------------------/
// +----------------------------------------------------------------------
// | Copyright (c) 2016 http://baimifan.cn All rights reserved.
// +----------------------------------------------------------------------
// | Author: 李上凡 ruoshuisixue@sina.com  创建时间: 2016/4/11_14:39  包名: xyz.ruoxue.opengl.ui.adapter.listAdapter
// +----------------------------------------------------------------------
public abstract class BasicExpandableListAdapter<T> extends BaseExpandableListAdapter {

    protected Context ctx;
    public List<MsgMode<T>> data;

    public BasicExpandableListAdapter(Context ctx, List<MsgMode<T>>  data) {
        this.ctx = ctx;
        this.data = data;

    }

    /**
     * Gets the number of groups.
     *
     * @return the number of groups
     */
    @Override
    public int getGroupCount() {
        return data.size();
    }

    /**
     * Gets the number of children in a specified group.
     *
     * @param groupPosition the position of the group for which the children
     *                      count should be returned
     * @return the children count in the specified group
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getList().size();
    }

    /**
     * Gets the data associated with the given group.
     *
     * @param groupPosition the position of the group
     * @return the data child for the specified group
     */
    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    /**
     * Gets the data associated with the given child within the given group.
     *
     * @param groupPosition the position of the group that the child resides in
     * @param childPosition the position of the child with respect to other
     *                      children in the group
     * @return the data of the child
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getList().get(childPosition);
    }

    /**
     * Gets the ID for the group at the given position. This group ID must be
     * unique across groups. The combined ID (see
     * {@link #getCombinedGroupId(long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group for which the ID is wanted
     * @return the ID associated with the group
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * Gets the ID for the given child within the given group. This ID must be
     * unique across all children within the group. The combined ID (see
     * {@link #getCombinedChildId(long, long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group for which
     *                      the ID is wanted
     * @return the ID associated with the child
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition*childPosition;
    }

    /**
     * Indicates whether the child and group IDs are stable across changes to the
     * underlying data.
     *
     * @return whether or not the same ID always refers to the same object
     * @see Adapter#hasStableIds()
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * Gets a View that displays the given group. This View is only for the
     * group--the Views for the group's children will be fetched using
     * {@link #getChildView(int, int, boolean, View, ViewGroup)}.
     *
     * @param groupPosition the position of the group for which the View is
     *                      returned
     * @param isExpanded    whether the group is expanded or collapsed
     * @param convertView   the old view to reuse, if possible. You should check
     *                      that this view is non-null and of an appropriate type before
     *                      using. If it is not possible to convert this view to display
     *                      the correct data, this method can create a new view. It is not
     *                      guaranteed that the convertView will have been previously
     *                      created by
     *                      {@link #getGroupView(int, boolean, View, ViewGroup)}.
     * @param parent        the parent that this view will eventually be attached to
     * @return the View corresponding to the group at the specified position
     */


    /**
     * Gets a View that displays the data for the given child within the given
     * group.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child (for which the View is
     *                      returned) within the group
     * @param isLastChild   Whether the child is the last child within the group
     * @param convertView   the old view to reuse, if possible. You should check
     *                      that this view is non-null and of an appropriate type before
     *                      using. If it is not possible to convert this view to display
     *                      the correct data, this method can create a new view. It is not
     *                      guaranteed that the convertView will have been previously
     *                      created by
     *                      {@link #getChildView(int, int, boolean, View, ViewGroup)}.
     * @param parent        the parent that this view will eventually be attached to
     * @return the View corresponding to the child at the specified position
     */


    /**
     * Whether the child at the specified position is selectable.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group
     * @return whether the child is selectable.
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
