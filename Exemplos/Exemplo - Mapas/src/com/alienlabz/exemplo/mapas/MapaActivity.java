package com.alienlabz.exemplo.mapas;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapaActivity extends Activity {
	private MapView mapView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);

		mapView = (MapView) findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		mapView.onResume();
		super.onResume();

		if (mapView.getMap() == null) {
			Toast.makeText(this, "Mapa indispon’vel", Toast.LENGTH_SHORT).show();
		} else {
			try {
				MapsInitializer.initialize(this);

				mapView.getMap().setMapType(GoogleMap.MAP_TYPE_HYBRID);
				mapView.getMap().addMarker(
						new MarkerOptions().position(new LatLng(-12.990481, -38.4947624)).title("Minha Casa!"));

				mapView.getMap().moveCamera(CameraUpdateFactory.zoomBy(30));
				mapView.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-12.990481, -38.4947624)));

				createPolyline();
			} catch (GooglePlayServicesNotAvailableException e) {
			}
		}
	}

	private void createPolyline() {
		PolylineOptions rectOptions = new PolylineOptions().add(new LatLng(37.35, -122.0))
				.add(new LatLng(-12.990481, -38.4947624))
				.add(new LatLng(-12.990485, -38.4947629))
				.add(new LatLng(-12.990490, -38.4947630))
				.add(new LatLng(-12.990500, -38.4947645));

		rectOptions.color(Color.RED);

		mapView.getMap().addPolyline(rectOptions);
	}

	@Override
	protected void onPause() {
		mapView.onPause();
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		mapView.onDestroy();
		super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mapView.onLowMemory();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_mapa, menu);
		return true;
	}

}
