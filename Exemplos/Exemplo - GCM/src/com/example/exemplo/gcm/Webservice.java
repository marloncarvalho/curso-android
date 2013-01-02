package com.example.exemplo.gcm;

import android.content.Context;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

public class Webservice {

	public static void register(Context context, String username, String regId) {
		String url = "http://192.168.25.7:9000/push/register/" + username + "/" + regId;
		String result = HttpUtil.doGet(url); 
		Log.d("Webservice", result);

		GCMRegistrar.setRegisteredOnServer(context, true);
	}

	public static void unregister(Context context, String regId) {
		String url = "http://192.168.25.7:9000/push/unregister/" + regId;
		String result = HttpUtil.doGet(url);
		Log.d("Webservice", result);

		GCMRegistrar.setRegisteredOnServer(context, false);
	}

}
