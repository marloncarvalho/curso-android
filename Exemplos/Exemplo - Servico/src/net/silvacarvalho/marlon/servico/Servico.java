package net.silvacarvalho.marlon.servico;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Servico extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public IBinder onBind(final Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 5; i++) {
					Log.d("Servio", "Servio!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				stopSelf();
			}

		}).start();

		return Service.START_STICKY;
	}

}
