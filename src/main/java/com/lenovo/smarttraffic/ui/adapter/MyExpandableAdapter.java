package com.lenovo.smarttraffic.ui.adapter;

import android.support.v4.app.Fragment;
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

public class MyExpandableAdapter extends BaseExpandableListAdapter {

    public List<GetBusInfoBean.ROWSDETAILBean> beans;
    public Fragment fragment;

    @Override
    public int getGroupCount() {
        return beans.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return beans.get(groupPosition).getSites().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return beans.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return beans.get(groupPosition).getSites().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    class GroupViewHolder {
        TextView tv_line_num;
        TextView tv_from_to;
        TextView tv_time1;
        TextView tv_price;
        TextView tv_time2;
        ImageView iv_arrow;
    }

    class ChildrenViewHolder {
        TextView tv_start;
        TextView tv_local;
    }

    GroupViewHolder groupViewHolder;
    ChildrenViewHolder childrenViewHolder;

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q47_group, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tv_line_num = convertView.findViewById(R.id.tv_line_num);
            groupViewHolder.tv_from_to = convertView.findViewById(R.id.tv_from_to);
            groupViewHolder.tv_time1 = convertView.findViewById(R.id.tv_time1);
            groupViewHolder.tv_price = convertView.findViewById(R.id.tv_price);
            groupViewHolder.tv_time2 = convertView.findViewById(R.id.tv_time2);
            groupViewHolder.iv_arrow = convertView.findViewById(R.id.iv_arrow);


            convertView.setTag(groupViewHolder);

        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        initGroup(groupPosition);

        return convertView;
    }

    private void initGroup(int groupPosition) {
        if (beans == null) {
            return;
        }
        groupViewHolder.tv_line_num.setText(beans.get(groupPosition).getName());
        groupViewHolder.tv_from_to.setText(beans.get(groupPosition).getSites().get(0) + "---" + beans.get(groupPosition).getSites().get(beans.get(groupPosition).getSites().size() - 1));
        groupViewHolder.tv_time1.setText(beans.get(groupPosition).getTime().get(0).getStarttime() + "--" + beans.get(groupPosition).getTime().get(0).getEndtime());
        groupViewHolder.tv_price.setText("票价：" + beans.get(groupPosition).getTicket() + "$");
        groupViewHolder.tv_time2.setText(beans.get(groupPosition).getTime().get(1).getStarttime() + "--" + beans.get(groupPosition).getTime().get(1).getEndtime());
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q47_child, parent, false);
            childrenViewHolder = new ChildrenViewHolder();
            childrenViewHolder.tv_start = convertView.findViewById(R.id.tv_start);
            childrenViewHolder.tv_local = convertView.findViewById(R.id.tv_local);
            convertView.setTag(childrenViewHolder);
        } else {
            childrenViewHolder = (ChildrenViewHolder) convertView.getTag();
        }

        initchild(childPosition, groupPosition);
        return convertView;
    }

    private void initchild(int childPosition, int groupPosition) {
        if (childPosition == 0) {
            childrenViewHolder.tv_start.setVisibility(View.VISIBLE);
            childrenViewHolder.tv_start.setText("起点：  ");
        } else if (childPosition == beans.get(groupPosition).getSites().size() - 1) {
            childrenViewHolder.tv_start.setVisibility(View.VISIBLE);
            childrenViewHolder.tv_start.setText("终点：  ");
        }else {
            childrenViewHolder.tv_start.setVisibility(View.INVISIBLE);
        }
        childrenViewHolder.tv_local.setText(beans.get(groupPosition).getSites().get(childPosition));
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
