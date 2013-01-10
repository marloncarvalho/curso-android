package com.alienlabz.exemplo.sensores;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity {
	private SensorManager sensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		listSensors();
	}

	/**
	 * Listar todos os sensores dispon’veis no dispositivo.
	 */
	private void listSensors() {
		StringBuilder result = new StringBuilder();
		List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

		for (Sensor sensor : sensors) {
			result.append(sensor.getName() + " - " + sensor.getVendor());
		}

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(result.toString());
		builder.create().show();
	}

}
