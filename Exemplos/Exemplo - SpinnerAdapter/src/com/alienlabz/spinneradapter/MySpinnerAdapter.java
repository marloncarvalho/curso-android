package com.alienlabz.spinneradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MySpinnerAdapter extends BaseAdapter {
	private Context context;

	public MySpinnerAdapter(Context context) {
		this.context = context;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(android.R.layout.simple_list_item_1, null);

		TextView text1 = (TextView) view.findViewById(android.R.id.text1);
		text1.setText("DropDownView: " + position);

		return view;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return "TextView";
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.dropdown_view, null);
		TextView text1 = (TextView) view.findViewById(R.id.dropdown_view_text1);
		TextView text2 = (TextView) view.findViewById(R.id.dropdown_view_text2);

		text1.setText("TextView1: " + position);
		text2.setText("TextView2: " + position);

		return view;
	}
}
