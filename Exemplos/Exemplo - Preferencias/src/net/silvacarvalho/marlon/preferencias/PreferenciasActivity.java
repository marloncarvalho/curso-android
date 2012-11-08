package net.silvacarvalho.marlon.preferencias;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenciasActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// addPreferencesFromResource(R.xml.preferencias);

		getFragmentManager()
			.beginTransaction()
			.replace(android.R.id.content, new PreferenciasFragment())
			.commit();
	}

}
