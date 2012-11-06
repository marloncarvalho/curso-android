package com.alienlabz.actionbar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

public class TabActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);

		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab tab1 = actionBar.newTab();
		tab1.setText("Tab 1");
		tab1.setTabListener(new MyTabListener<Fragment>(this, "Tab 1", Tab1Fragment.class));
		actionBar.addTab(tab1);

		Tab tab2 = actionBar.newTab();
		tab2.setText("Tab 2");
		tab2.setTabListener(new MyTabListener<Fragment>(this, "Tab 2", Tab2Fragment.class));
		actionBar.addTab(tab2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab, menu);
		return true;
	}

}
