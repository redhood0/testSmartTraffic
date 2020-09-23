package com.lenovo.smarttraffic.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.bean.GroupBean;

import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    List<String> groups;


    List<GroupBean> groupBeans;

    public ExpandableAdapter(List<String> groups,List<GroupBean> groupBeans) {
        this.groups = groups;
        this.groupBeans = groupBeans;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupBeans.get(groupPosition).getChildBeanList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupBeans.get(groupPosition).getChildBeanList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //Todo:不知道有什么用
    @Override
    public boolean hasStableIds() {
        return false;
    }

    static class GroupViewHolder {
        TextView parent_textview_id;
        ImageView parent_image;
    }

    static class SonViewHolder {
        TextView tv_zhan1_num1;
        TextView tv_zhan1_people1;
        TextView tv_zhan1_time1;
        TextView tv_zhan1_display1;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expand_father_q10, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.parent_textview_id = (TextView) convertView.findViewById(R.id.tv_station);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        initGroupView(groupViewHolder,groupPosition);
        return convertView;
    }

    private void initGroupView(GroupViewHolder groupViewHolder, int groupPosition) {
        groupViewHolder.parent_textview_id.setText(groups.get(groupPosition));
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SonViewHolder sonViewHolder = new SonViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expand_son_q10, parent, false);
            ;
            sonViewHolder.tv_zhan1_display1 = convertView.findViewById(R.id.tv_zhan1_display1);
            sonViewHolder.tv_zhan1_num1 = convertView.findViewById(R.id.tv_zhan1_num1);
            sonViewHolder.tv_zhan1_people1 = convertView.findViewById(R.id.tv_zhan1_people1);
            sonViewHolder.tv_zhan1_time1 = convertView.findViewById(R.id.tv_zhan1_time1);
            convertView.setTag(sonViewHolder);
        } else {
            convertView.getTag();
        }
        initChildView(sonViewHolder,groupPosition,childPosition);
        return convertView;
    }

    private void initChildView(SonViewHolder sonViewHolder, int groupPosition,int childPosition) {
        sonViewHolder.tv_zhan1_num1.setText(groupBeans.get(groupPosition).getChildBeanList().get(childPosition).getTv_zhan1_num1());
        sonViewHolder.tv_zhan1_display1.setText(groupBeans.get(groupPosition).getChildBeanList().get(childPosition).getTv_zhan1_display1());

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
