package com.alienlabz.exemplo.asynctaskloader;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements LoaderCallbacks<String> {
	public static final int LOADER_TEST = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Loader<String> loader = getLoaderManager().initLoader(LOADER_TEST, new Bundle(), this);
		loader.forceLoad();
	}

	@Override
	public Loader<String> onCreateLoader(int id, Bundle args) {
		if (id == LOADER_TEST) {
			return new TaskLoader(this);
		}
		return null;
	}

	@Override
	public void onLoadFinished(Loader<String> loader, String data) {
		Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onLoaderReset(Loader<String> loader) {
	}

}
