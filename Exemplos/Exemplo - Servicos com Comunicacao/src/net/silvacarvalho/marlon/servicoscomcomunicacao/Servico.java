package net.silvacarvalho.marlon.servicoscomcomunicacao;

import java.util.Date;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class Servico extends IntentService {

	public Servico() {
		super("serviço");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Intent i = new Intent("Broadcast");
		i.putExtra("Extra", "Extra:" + new Date().getTime());
		LocalBroadcastManager.getInstance(this).sendBroadcast(i);
	}

}
