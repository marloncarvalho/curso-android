package com.alienlabz.exemplo.sensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class AccelerometerActivity extends Activity {
	private SensorManager sensorManager;
	private Sensor sensor;
	private SensorEventListener listener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			Toast.makeText(AccelerometerActivity.this,
					"Sensor: " + event.values[0] + ", " + event.values[1] + ", " + event.values[2], Toast.LENGTH_SHORT)
					.show();
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proximity_sensor);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

	}

	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(listener, sensor);
	}

}
