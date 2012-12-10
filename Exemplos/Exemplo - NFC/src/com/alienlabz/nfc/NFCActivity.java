package com.alienlabz.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Exemplo de uso de NFC.
 * 
 * @author Marlon Silva Carvalho
 * @since 1.0.0
 */
public class NFCActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfc);
	}

	@Override
	protected void onPause() {
		super.onPause();
		final NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		if (nfcAdapter != null) {
			nfcAdapter.disableForegroundDispatch(this);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		final NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		if (nfcAdapter != null) {
			final PendingIntent intent = PendingIntent.getActivity(this, 0,
					new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0, null);
			nfcAdapter.enableForegroundDispatch(this, intent, null, null);
		}

		final String action = getIntent().getAction();
		if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
			Toast.makeText(this, "NFC", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Toast.makeText(this, "NFC", Toast.LENGTH_SHORT).show();
		Tag tag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
	}

}
