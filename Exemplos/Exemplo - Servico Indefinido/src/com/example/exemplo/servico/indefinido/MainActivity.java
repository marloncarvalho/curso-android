package com.example.exemplo.servico.indefinido;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.exemplo.servico.indefinido.Servico.LocalBinder;

public class MainActivity extends Activity {
	private Button button;
	private Servico servico;
	private boolean bound;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = new Intent(MainActivity.this, Servico.class);
		startService(intent);

		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!bound) {
					Intent intent = new Intent(MainActivity.this, Servico.class);
					bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
				}
				Toast.makeText(MainActivity.this, "Veio: " + servico.getValor(), Toast.LENGTH_LONG).show();
			}

		});

		bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
	}

	private ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName className, IBinder service) {
			LocalBinder binder = (LocalBinder) service;
			servico = binder.getServico();
			bound = true;
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			bound = false;
		}
	};
}
