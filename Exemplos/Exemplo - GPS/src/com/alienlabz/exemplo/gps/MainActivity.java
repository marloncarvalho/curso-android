package com.alienlabz.exemplo.gps;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button on;
	private Button off;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		on = (Button) findViewById(R.id.button_on);
		off = (Button) findViewById(R.id.button_off);
		final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		final LocationListener listener = new LocationListener() {

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}

			@Override
			public void onProviderEnabled(String provider) {
			}

			@Override
			public void onProviderDisabled(String provider) {
			}

			@Override
			public void onLocationChanged(Location location) {
				location.getLatitude();
				location.getAltitude();
				location.getAccuracy();
			}
		};

		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

		}

		on.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
			}

		});

		off.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				locationManager.removeUpdates(listener);
			}

		});

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
