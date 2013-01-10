package net.silvacarvalho.marlon.asynctask.simples;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button button;
	private TextView textView;
	private AsyncTask<Void, Void, Void> task;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button1);
		textView = (TextView) findViewById(R.id.textView1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				task = new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {

//						isCancelled();
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {

					}

					@Override
					protected void onCancelled() {
						super.onCancelled();
					}

				};

				task.execute();
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(task!=null) {
			task.cancel(true);
		}
	}

}
