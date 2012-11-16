package com.alienlabz.spinneradapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private Spinner spinner;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(new MySpinnerAdapter(this));
	}

}
