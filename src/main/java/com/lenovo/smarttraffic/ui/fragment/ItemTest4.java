package com.lenovo.smarttraffic.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ItemTest4 extends Fragment {
    public static ItemTest4 item;
    @BindView(R.id.expand)
    ExpandableListView expand;
    Unbinder unbinder;

    public static ItemTest4 getInstance() {
        if (item == null) {
            item = new ItemTest4();
        } else {

        }
        return item;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_test_4, container, false);
        unbinder = ButterKnife.bind(this, v);


        MyExpAdapter adapter = new MyExpAdapter();
        List<GroupBean1> groupBean1s = new ArrayList<>();
        GroupBean1 groupBean1 = new GroupBean1();
        groupBean1.group = "组1";
        groupBean1.childBean1s = new ArrayList<>();
        groupBean1.childBean1s.add(new ChildBean1());
        groupBean1.childBean1s.add(new ChildBean1());

        GroupBean1 groupBean2 = new GroupBean1();
        groupBean2.group = "组2";
        groupBean2.childBean1s = new ArrayList<>();
        groupBean2.childBean1s.add(new ChildBean1());
        groupBean2.childBean1s.add(new ChildBean1());

        groupBean1s.add(groupBean1);
        groupBean1s.add(groupBean2);
        adapter.setGroupBean1s(groupBean1s);
        expand.setAdapter(adapter);
        expand.collapseGroup(0);
        expand.expandGroup(1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                groupBean1.group = "组1" + Math.random() * 1000;
                groupBean2.group = "组2" + Math.random() * 1000;
                expand.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        expand.invalidate();
                    }
                });
            }
        }, 0, 1000);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    class GroupBean1 {
        String group;
        List<ChildBean1> childBean1s;
    }

    class ChildBean1 {

    }


    class MyExpAdapter extends BaseExpandableListAdapter {
        List<GroupBean1> groupBean1s;

        public void setGroupBean1s(List<GroupBean1> groupBean1s) {
            this.groupBean1s = groupBean1s;
        }

        @Override
        public int getGroupCount() {
            return groupBean1s.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return groupBean1s.get(groupPosition).childBean1s.size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupBean1s.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return groupBean1s.get(groupPosition).childBean1s.get(childPosition);
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

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_just_text, parent, false);
            TextView tv = v.findViewById(R.id.tv);
            tv.setText(groupBean1s.get(groupPosition).group);
            return v;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_just_text, parent, false);
            TextView tv = v.findViewById(R.id.tv);
            tv.setText("" + (int) (Math.random() * 10000 * (childPosition + 1)) + "米");
            return v;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
