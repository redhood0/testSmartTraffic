package com.lenovo.smarttraffic.ui.adapter;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q28Bean;

import java.util.ArrayList;
import java.util.List;

public class Q28ExpandableAdapter extends BaseExpandableListAdapter {

   public List<Q28Bean> q28Beans = new ArrayList<>();

    @Override
    public int getGroupCount() {
        return q28Beans.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return q28Beans.get(groupPosition).getChilds().size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return q28Beans.get(groupPosition).getGroup();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return q28Beans.get(groupPosition).getChilds().get(childPosition);
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
        return true;
    }
   class GroupHold{
        TextView tv;
   }
    class ChildHold{
        TextView tv;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHold groupHold;
        if(convertView == null){
            groupHold = new GroupHold();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_just_text,parent,false);
            groupHold.tv =  convertView.findViewById(R.id.tv);
            convertView.setTag(groupHold);
        }else {
            groupHold = (GroupHold)convertView.getTag();
        }
        groupHold.tv.setText(q28Beans.get(groupPosition).getGroup());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHold childHold;
        if(convertView == null){
            childHold = new ChildHold();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_just_text,parent,false);
            childHold.tv =  convertView.findViewById(R.id.tv);
            convertView.setTag(childHold);
        }else {
            childHold = (ChildHold)convertView.getTag();
        }
        childHold.tv.setText(q28Beans.get(groupPosition).getChilds().get(childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
