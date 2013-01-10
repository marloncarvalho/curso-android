package com.alienlabz.exemplo.sensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class LightActivity extends Activity {
	private SensorManager sensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_light_sensor);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		sensorManager.registerListener(new SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Toast.makeText(LightActivity.this, "Sensor: " + event.values[0], Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {

			}

		}, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

}
