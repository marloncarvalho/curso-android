package com.alienlabz.popup.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends Activity {
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
				MenuInflater inflater = popupMenu.getMenuInflater();
				inflater.inflate(R.menu.activity_main, popupMenu.getMenu());
				popupMenu.show();
			}

		});
	}

}
