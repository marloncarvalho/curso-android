package com.alienlabz.exemplo.sensores;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.alienlabz.exemplo.sensores.ShakeDetector.OnShakeListener;

public class ShakeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shake);

		ShakeDetector shake = new ShakeDetector(this);
		shake.setOnShakeListener(new OnShakeListener() {

			@Override
			public void onShake() {
				Toast.makeText(ShakeActivity.this, "Shake!", Toast.LENGTH_SHORT).show();
			}

		});
	}

}
