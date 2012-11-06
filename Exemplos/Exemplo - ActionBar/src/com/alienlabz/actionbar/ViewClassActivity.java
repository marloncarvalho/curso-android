package com.alienlabz.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;

public class ViewClassActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_class);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_view_class, menu);
		SearchView view = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		view.setOnSearchClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});
		return true;
	}
}
