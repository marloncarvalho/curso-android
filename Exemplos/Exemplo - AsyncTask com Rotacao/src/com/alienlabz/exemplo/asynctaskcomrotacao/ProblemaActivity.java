package com.alienlabz.exemplo.asynctaskcomrotacao;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class ProblemaActivity extends Activity {
	private static final int MAX_COUNT = 100;
	private static final int SLEEP_TIME = 200;
	private ProgressBar progressBar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressBar = (ProgressBar) findViewById(R.id.progress);
		progressBar.setMax(MAX_COUNT);

		new MyTask().execute();
	}

	class MyTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected void onProgressUpdate(Integer... values) {
			progressBar.setProgress(values[0]);
			Log.d("MyTask", "onProgressUpdate: " + values[0] + " na Activity: " + ProblemaActivity.this.hashCode());
		}

		@Override
		protected Void doInBackground(Void... params) {
			for (int i = 0; i < MAX_COUNT; i++) {
				try {
					Log.d("MyTask", "doInBackground: " + i);
					publishProgress(i);
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("ProblemaActivity", "onDestroy: " + hashCode());
	}

}
