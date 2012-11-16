package com.alienlabz.servicos.ibinder;

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

import com.alienlabz.servicos.ibinder.ServicoLocal.LocalBinder;

public class MainActivity extends Activity {
	private ServicoLocal servico;
	private boolean bound = false;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (bound) {
					Toast.makeText(MainActivity.this, servico.meDeAParada(), Toast.LENGTH_LONG).show();
				}
			}

		});

		Intent intent = new Intent(this, ServicoLocal.class);
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
