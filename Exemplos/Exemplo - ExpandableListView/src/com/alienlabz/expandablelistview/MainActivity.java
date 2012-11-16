package com.alienlabz.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
	private ExpandableListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ExpandableListView) findViewById(R.id.expandableListView1);
		MyAdapter adapter = new MyAdapter(this);
		adapter.add("Grupo 1", "G1 V1");
		adapter.add("Grupo 1", "G1 V2");
		adapter.add("Grupo 1", "G1 V3");
		
		adapter.add("Grupo 2", "G2 V1");
		adapter.add("Grupo 2", "G2 V2");
		adapter.add("Grupo 2", "G2 V3");
		listView.setAdapter(adapter);
	}
	
}
