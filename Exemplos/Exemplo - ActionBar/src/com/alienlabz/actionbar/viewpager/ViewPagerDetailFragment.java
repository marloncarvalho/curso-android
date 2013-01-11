package com.alienlabz.actionbar.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alienlabz.actionbar.R;

public class ViewPagerDetailFragment extends Fragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.viewpager_details, container, false);
		TextView textView = (TextView) view.findViewById(R.id.detailsText);
		textView.setText("Teste");
		return view;
	}

}
