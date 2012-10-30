package com.alienlabz.exemplo.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaFragment extends Fragment {
	private OnItemListSelectedListener mListener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnItemListSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement OnItemListSelectedListener");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_lista, container, false);

		ListView listView = (ListView) view.findViewById(R.id.lista);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int arg2, long arg3) {
				mListener.onItemSelected();
			}

		});
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
				android.R.id.text1);

		adapter.add("Item 1");
		adapter.add("Item 2");
		adapter.add("Item 3");

		listView.setAdapter(adapter);

		return view;
	}

	public interface OnItemListSelectedListener {
		public void onItemSelected();
	}

}
