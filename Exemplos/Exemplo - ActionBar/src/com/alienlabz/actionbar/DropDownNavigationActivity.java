package com.alienlabz.actionbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class DropDownNavigationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		Map<String, String> valor1 = new HashMap<String, String>();
		valor1.put("nome", "Marlon");

		Map<String, String> valor2 = new HashMap<String, String>();
		valor2.put("nome", "Marlon 2");

		List<Map<String, String>> lista = new ArrayList<Map<String, String>>();
		lista.add(valor1);
		lista.add(valor2);

		String[] from = new String[] { "nome" };
		int[] to = new int[] { android.R.id.text1 };

		SimpleAdapter adapter = new SimpleAdapter(this, lista, android.R.layout.simple_list_item_1, from, to);
		actionBar.setListNavigationCallbacks(adapter, new OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				return false;
			}

		});
	}

}
