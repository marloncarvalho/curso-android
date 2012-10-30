package net.silvacarvalho.marlon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

/**
 * Uma Activity pode ser entendida como um Controlador dos eventos de uma
 * "Tela".
 * 
 * Mas também toda a tela pode ser construída na Activity, entretanto, evite
 * esta prática.
 * 
 * @author Marlon Silva Carvalho
 */
public class MainActivity extends Activity {
	// Toda Activity precisa ser declarada no AndroidManifest.xml

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Todos os elementos de interface estendem de View.
		EditText editText = new EditText(this);
		editText.setHint("Isso é um hint");

		// setContentView(R.layout.activity_main);
		setContentView(editText);

		Log.d("CicloDeVidaDaActivity", "OnCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.d("CicloDeVidaDaActivity", "OnStart");
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.d("CicloDeVidaDaActivity", "OnStop");
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.d("CicloDeVidaDaActivity", "OnResume");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("CicloDeVidaDaActivity", "OnDestroy");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();

		Log.d("CicloDeVidaDaActivity", "OnLowMemory");
	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.d("CicloDeVidaDaActivity", "OnPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		Log.d("CicloDeVidaDaActivity", "OnRestart");
	}

}
