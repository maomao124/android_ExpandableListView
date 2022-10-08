package mao.android_expandablelistview.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;

import java.util.List;

import mao.android_expandablelistview.R;
import mao.android_expandablelistview.entity.Group;
import mao.android_expandablelistview.entity.Item;

/**
 * Project name(项目名称)：android_ExpandableListView
 * Package(包名): mao.android_expandablelistview.adapter
 * Class(类名): MyBaseExpandableListAdapter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/8
 * Time(创建时间)： 13:57
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter
{

    /**
     * 上下文
     */
    private final Context context;


    /**
     * 组数据
     */
    private final List<Group> groupData;

    /**
     * 项数据
     */
    private final List<List<Item>> ItemData;


    public MyBaseExpandableListAdapter(Context context, List<Group> groupData, List<List<Item>> itemData)
    {
        this.context = context;
        this.groupData = groupData;
        ItemData = itemData;
    }

    /**
     * 得到组数
     *
     * @return int
     */
    @Override

    public int getGroupCount()
    {
        return groupData.size();
    }

    /**
     * 获得孩子数
     *
     * @param groupPosition 组位置
     * @return int
     */
    @Override
    public int getChildrenCount(int groupPosition)
    {
        return ItemData.get(groupPosition).size();
    }

    /**
     * 获得Group
     *
     * @param groupPosition 组位置
     * @return {@link Object}
     */
    @Override
    public Object getGroup(int groupPosition)
    {
        return groupData.get(groupPosition);
    }

    /**
     * getChild
     *
     * @param groupPosition 组位置
     * @param childPosition 孩子位置
     * @return {@link Object}
     */
    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return ItemData.get(groupPosition).get(childPosition);
    }

    /**
     * 得到组id
     *
     * @param groupPosition 组位置
     * @return long
     */
    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    /**
     * 让孩子id
     *
     * @param groupPosition 组位置
     * @param childPosition 孩子位置
     * @return long
     */
    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return groupPosition * 100000L + childPosition;
    }

    /**
     * 有稳定id
     *
     * @return boolean
     */
    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    /**
     * 得到Group视图
     *
     * @param groupPosition 组位置
     * @param isExpanded    isExpanded
     * @param convertView   convertView
     * @param parent        parent
     * @return {@link View}
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        ViewHolderGroup viewHolderGroup;
        if (convertView == null)
        {
            viewHolderGroup = new ViewHolderGroup();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_exlist_group, parent, false);
            viewHolderGroup.tv_group_name = convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(viewHolderGroup);
        }
        else
        {
            viewHolderGroup = (ViewHolderGroup) convertView.getTag();
        }
        viewHolderGroup.tv_group_name.setText(groupData.get(groupPosition).getName());
        return convertView;
    }

    /**
     * 得到子视图
     *
     * @param groupPosition 组位置
     * @param childPosition 孩子位置
     * @param isLastChild   是否为最后孩子
     * @param convertView   convertView
     * @param parent        parent
     * @return {@link View}
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        ViewHolderItem viewHolderItem;
        if (convertView == null)
        {
            viewHolderItem = new ViewHolderItem();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_exlist_item, parent, false);
            viewHolderItem.img_icon = convertView.findViewById(R.id.img_icon);
            viewHolderItem.tv_name = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolderItem);
        }
        else
        {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }
        viewHolderItem.img_icon.setImageResource(ItemData.get(groupPosition).get(childPosition).getIcon());
        viewHolderItem.tv_name.setText(ItemData.get(groupPosition).get(childPosition).getName());

        convertView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Log.d("adapter", "onLongClick: ");

                new AlertDialog.Builder(context)
                        .setTitle("删除提示")
                        .setMessage("是否删除第" + (groupPosition + 1) + "个组的第" + (childPosition + 1) + "项?")
                        .setPositiveButton("确定删除", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                ItemData.get(groupPosition).remove(childPosition);
                                MyBaseExpandableListAdapter.this.notifyDataSetChanged();
                                toastShow("已删除");
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create()
                        .show();

                return true;
            }
        });

        convertView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toastShow("点击了第" + (groupPosition + 1) + "个组的第" + (childPosition + 1) + "项");
            }
        });

        return convertView;
    }

    /**
     * 设置子列表是否可选中
     *
     * @param groupPosition 组位置
     * @param childPosition 孩子位置
     * @return boolean
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }


    private static class ViewHolderGroup
    {
        private TextView tv_group_name;
    }

    private static class ViewHolderItem
    {
        private ImageView img_icon;
        private TextView tv_name;
    }


    /**
     * 显示消息
     *
     * @param message 消息
     */
    private void toastShow(String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
