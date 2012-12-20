package net.silvacarvalho.marlon.telefone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class TelefoneReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
		Toast.makeText(context, "LIGA‚ÌO: ", Toast.LENGTH_LONG).show();
	}

}
