package net.silvacarvalho.marlon.handlerstimers;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button1);
		final Handler handler = new Handler();

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(MainActivity.this, "Tempo!", Toast.LENGTH_SHORT).show();
					}

				}, 5000);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
