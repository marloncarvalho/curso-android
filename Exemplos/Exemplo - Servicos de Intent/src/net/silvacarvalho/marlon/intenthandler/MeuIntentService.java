package net.silvacarvalho.marlon.intenthandler;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MeuIntentService extends IntentService {

	public MeuIntentService() {
		super("Serviço");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("Teste", "Mensagem do IntentService!");
	}

}
