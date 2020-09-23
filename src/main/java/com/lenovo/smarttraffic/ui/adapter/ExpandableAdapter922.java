package com.lenovo.smarttraffic.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ExpandableBean;

import java.util.ArrayList;
import java.util.List;

public class ExpandableAdapter922 extends BaseExpandableListAdapter {
    List<String> groups;
    List<ArrayList<ExpandableBean>> childs;
    Context context;
    LayoutInflater inflater;

    public ExpandableAdapter922(List<String> groups, List<ArrayList<ExpandableBean>> childs, Context context) {
        this.groups = groups;
        this.childs = childs;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs.get(groupPosition).get(childPosition);
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.expandable_father_922,parent,false);
        }
       TextView tv =  convertView.findViewById(R.id.tv_f);
        tv.setText(groups.get(groupPosition));
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.expandable_child_922,parent,false);
        }
        TextView tv_carnum =  convertView.findViewById(R.id.tv_carnum);
        TextView tv_humans =  convertView.findViewById(R.id.tv_humans);
        TextView tv_time =  convertView.findViewById(R.id.tv_time);
        TextView tv_distance =  convertView.findViewById(R.id.tv_distance);

        tv_carnum.setText(childs.get(groupPosition).get(childPosition).getCarNUm()+"号");
        tv_humans.setText(childs.get(groupPosition).get(childPosition).getNum()+"人");
        tv_time.setText(childs.get(groupPosition).get(childPosition).getMinute()+"分钟到达");
        tv_distance.setText("距离站台："+childs.get(groupPosition).get(childPosition).getDistance()+"米");

        return convertView;
    }

    //子项是否可选
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
