package com.alienlabz.expandablelistview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseExpandableListAdapter {
	private Context context;
	private Map<String, List<String>> values = new TreeMap<String, List<String>>();
	private List<String> groups;

	public MyAdapter(Context context) {
		this.context = context;
	}

	public void add(String group, String value) {
		if (values.containsKey(group)) {
			List<String> list = values.get(group);
			list.add(value);
		} else {
			List<String> list = new ArrayList<String>();
			list.add(value);
			values.put(group, list);
			groups = new ArrayList<String>(values.keySet());
		}
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		String groupName = groups.get(groupPosition);
		List<String> strings = values.get(groupName);
		return strings.get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {

		String groupName = groups.get(groupPosition);
		List<String> strings = values.get(groupName);
		TextView textView = new TextView(context);
		textView.setText(strings.get(childPosition));

		return textView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		String groupName = groups.get(groupPosition);
		return values.get(groupName).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		String groupName = groups.get(groupPosition);
		return groupName;
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		TextView textView = new TextView(context);
		textView.setTextColor(Color.GRAY);
		textView.setTextSize(20);
		textView.setText(groups.get(groupPosition));
		return textView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
}
