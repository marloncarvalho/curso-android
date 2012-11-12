package net.silvacarvalho.marlon.preferencias;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class PreferenciasFragment extends PreferenceFragment {
	private OnSharedPreferenceChangeListener listener = new OnSharedPreferenceChangeListener() {

		@Override
		public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
			Toast.makeText(getActivity(), "MUDOU!", Toast.LENGTH_SHORT).show();
		}

	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
		// prefs.edit().putString("Pref1", "TESTE");
		// prefs.edit().commit();
		prefs.registerOnSharedPreferenceChangeListener(listener);

		addPreferencesFromResource(R.xml.preferencias);
	}
}
