package com.alienlabz.exemplo.asynctaskloader;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class TaskLoader extends AsyncTaskLoader<String> {

	public TaskLoader(Context context) {
		super(context);
	}

	@Override
	public String loadInBackground() {
		return "Executou";
	}

}
