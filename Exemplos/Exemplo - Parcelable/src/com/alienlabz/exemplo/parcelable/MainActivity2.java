package com.alienlabz.exemplo.parcelable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);

		if (getIntent().getExtras() != null) {
			ParcelData data = getIntent().getExtras().getParcelable("TESTE");
			Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
		return true;
	}

}
