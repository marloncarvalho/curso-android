package net.silvacarvalho.marlon.intenthandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = new Intent(this, MeuIntentService.class);
		startService(intent);
		startService(intent);
		startService(intent);
		startService(intent);
		startService(intent);
	}

}
