package com.alienlabz.exemplo.asynctaskcomrotacao;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements LoaderCallbacks<Void> {
	private static final int MAX_COUNT = 100;
	private static final int SLEEP_TIME = 200;
	private ProgressBar progressBar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressBar = (ProgressBar) findViewById(R.id.progress);
		progressBar.setMax(MAX_COUNT);

		MyLoader.mActivity = new WeakReference<MainActivity>(this);
		getLoaderManager().initLoader(0, new Bundle(), this);
	}

	@Override
	public Loader<Void> onCreateLoader(int id, Bundle args) {
		Loader<Void> loader = new MyLoader(this);
		loader.forceLoad();
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<Void> arg0, Void arg1) {
	}

	@Override
	public void onLoaderReset(Loader<Void> arg0) {
	}

	static class MyLoader extends AsyncTaskLoader<Void> {
		private static WeakReference<MainActivity> mActivity;

		public MyLoader(MainActivity activity) {
			super(activity);
			mActivity = new WeakReference<MainActivity>(activity);
		}

		@Override
		public Void loadInBackground() {
			for (int i = 0; i < MAX_COUNT; i++) {
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				final int progress = i;
				if (mActivity.get() != null) {
					mActivity.get().runOnUiThread(new Runnable() {

						@Override
						public void run() {
							mActivity.get().progressBar.setProgress(progress);
						}

					});
				}
			}

			return null;
		}

	}

}
