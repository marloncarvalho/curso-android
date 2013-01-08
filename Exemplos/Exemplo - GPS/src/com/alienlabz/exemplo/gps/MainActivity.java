package com.alienlabz.exemplo.gps;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button on;
	private Button off;
	private LocationManager locationManager;

	private LocationListener listener = new LocationListener() {

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
			showLocation(location);
		}
	};

	private void showLocation(Location location) {
		StringBuilder strAddress = new StringBuilder();
		Geocoder geocoder = new Geocoder(this);

		try {
			List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
			for (Address address : addresses) {
				strAddress.append(address.getAddressLine(0));
			}
		} catch (IOException e) {
		}

		Toast.makeText(
				MainActivity.this,
				"Localização encontrada: " + location.getLatitude() + ", " + location.getLongitude() + "-" + strAddress,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		on = (Button) findViewById(R.id.button_on);
		off = (Button) findViewById(R.id.button_off);

		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if (location != null) {

			Toast.makeText(this,
					"Última localização por GPS: " + location.getLatitude() + ", " + location.getLongitude(),
					Toast.LENGTH_SHORT).show();
		} else {

			location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			Toast.makeText(this,
					"Última localização por Network: " + location.getLatitude() + ", " + location.getLongitude(),
					Toast.LENGTH_SHORT).show();
		}

		on.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

					Toast.makeText(MainActivity.this, "Usando GPS", Toast.LENGTH_SHORT).show();
					locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
				} else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

					Toast.makeText(MainActivity.this, "Usando Network", Toast.LENGTH_SHORT).show();
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
				} else {

					Toast.makeText(MainActivity.this, "Nenhum provedor disponível.", Toast.LENGTH_SHORT).show();
				}
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
		locationManager.removeUpdates(listener);
	}

}
