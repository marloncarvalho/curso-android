package net.silvacarvalho.marlon.telefone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TelefoneReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "LIGA‚ÌO", Toast.LENGTH_LONG).show();
	}

}
