package net.silvacarvalho.marlon.handlers.threads;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView textView;
	private Button button;
	private Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				button.setText("Bot‹o");

				Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_LONG).show();
			}

		};

		textView = (TextView) findViewById(R.id.textView1);
		button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new Thread(new Runnable() {

					@Override
					public void run() {

						Message msg = Message.obtain();
						msg.obj = "obj";
						msg.arg1 = 1;
						msg.arg2 = 2;

						handler.sendMessage(msg);

						handler.post(new Runnable() {

							@Override
							public void run() {
								textView.setText("MUDANDO O TExTO!");
							}

						});
					}

				}).start();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
