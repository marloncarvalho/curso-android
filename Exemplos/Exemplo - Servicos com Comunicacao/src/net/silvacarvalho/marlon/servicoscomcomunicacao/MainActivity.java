package net.silvacarvalho.marlon.servicoscomcomunicacao;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button button;
	private EditText editText;
	private BroadcastReceiver receiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			editText.setText(intent.getExtras().getString("Extra"));
		}

	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("Broadcast"));

		button = (Button) findViewById(R.id.button1);
		editText = (EditText) findViewById(R.id.editText1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Servico.class);
				startService(intent);
			}

		});
	}
}
