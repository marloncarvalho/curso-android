package com.alienlabz.conta;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ContactSyncAdapterService extends Service {
	private ContactSyncAdapter adapter;

	@Override
	public IBinder onBind(Intent intent) {
		return getContactSyncAdapter().getSyncAdapterBinder();
	}

	public ContactSyncAdapter getContactSyncAdapter() {
		if (adapter == null) {
			adapter = new ContactSyncAdapter(this, true);
		}
		return adapter;
	}

}
