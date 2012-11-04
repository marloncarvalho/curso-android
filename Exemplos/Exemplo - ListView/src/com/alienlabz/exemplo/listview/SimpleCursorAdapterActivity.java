package com.alienlabz.exemplo.listview;

import android.app.Activity;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.GridView;

public class SimpleCursorAdapterActivity extends Activity {
	private GridView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (GridView) findViewById(R.id.listView);
		String[] columns = new String[] { "_id", "col1" };

		MatrixCursor cursor = new MatrixCursor(columns, 2);
		cursor.addRow(new String[] { "1", "Item 1" });
		cursor.addRow(new String[] { "2", "Item 2" });
		cursor.addRow(new String[] { "3", "Item 3" });
		cursor.addRow(new String[] { "4", "Item 4" });

		String[] from = new String[] { "col1" };
		int[] to = new int[] { android.R.id.text1 };

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from,
				to, 0);

		listView.setAdapter(adapter);
	}

}
