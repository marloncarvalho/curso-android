package net.silvacarvalho.marlon.problema.threads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button button;
	private TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button1);
		textView = (TextView) findViewById(R.id.textView1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					private int qtd = 0;

					@Override
					public void run() {
						textView.setText("Contando: " + qtd++);
					}

				}).start();
			}

		});
	}

}
