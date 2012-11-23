package net.silvacarvalho.marlon.notificacao;

import android.app.IntentService;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class Servico extends IntentService {

	public Servico() {
		super("MEU SERVI‚O!");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		Notification.Builder builder = new Builder(this);
		builder.setWhen(System.currentTimeMillis());
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setTicker("Olha a Faaaaca!");
		builder.setContentTitle("Content Title");
		builder.setContentText("Content Text");
		builder.setContentInfo("Content Info");
		builder.setDefaults(Notification.DEFAULT_ALL);
		builder.setVibrate(new long[] { 0, 100, 100, 200, 100, 200 });
		builder.setLights(0xff000000, 10, 10);

		Intent i = new Intent(this, Main2Activity.class);

		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
		builder.setContentIntent(pendingIntent);

		Notification not = builder.build();
		not.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_SHOW_LIGHTS;

		notificationManager.notify(1, not);
	}

}
