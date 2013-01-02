package com.example.exemplo.gcm;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		configureGCM();
	}

	/**
	 * Configuring Google Cloud Messaging.
	 */
	private void configureGCM() {
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);

		final String regId = GCMRegistrar.getRegistrationId(this);

		if (regId == null || "".equals(regId)) {
			GCMRegistrar.register(this, GCMIntentService.SENDER_ID);
		} else {
			if (!GCMRegistrar.isRegisteredOnServer(this)) {
				new AsyncTask<Void, String, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						Webservice.register(MainActivity.this, "marloncarvalho", regId);
						return null;
					}

				}.execute();

			} else {
				GCMRegistrar.unregister(this);
			}
		}
	}
}
