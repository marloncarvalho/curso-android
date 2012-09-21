package net.silvacarvalho.marlon.servicos.alarmmanager;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ServicoIntent extends IntentService {

	public ServicoIntent() {
		super("Serviço");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("TAG", "FOI!");
	}

}
