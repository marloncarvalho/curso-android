package com.alienlabz.exemplo.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);

		List<Map<String, String>> lista = new ArrayList<Map<String, String>>();

		Map<String, String> value1 = new HashMap<String, String>();
		value1.put("rowid", "1");
		value1.put("col1", "Teste 1");

		Map<String, String> value2 = new HashMap<String, String>();
		value2.put("rowid", "1");
		value2.put("col1", "Teste 1");

		lista.add(value1);
		lista.add(value2);

		String[] from = new String[] { "col1" };
		int[] to = new int[] { android.R.id.text1 };

		SimpleAdapter adapter = new SimpleAdapter(this, lista, android.R.layout.simple_list_item_1, from, to);
		listView.setAdapter(adapter);
	}

}
