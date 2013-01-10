package com.example.exemplo.servico.indefinido;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class Servico extends Service {
	private IBinder binder = new LocalBinder();
	private int valor = 1;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Log.d("SERVICO DEBUG", "onStartCommand");

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					valor++;
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					Intent intent = new Intent(Servico.this, MainActivity.class);
					startActivity(intent);

					sendBroadcast(intent);
				}

			}
		}).start();

		return Service.START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	public String getValor() {
		return "ALGO: " + valor;
	}

	public class LocalBinder extends Binder {

		public Servico getServico() {
			return Servico.this;
		}

	}

}
