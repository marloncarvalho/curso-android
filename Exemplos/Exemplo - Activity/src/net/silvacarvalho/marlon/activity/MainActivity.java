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
 * @author Marlon Silva Carvalho
 */
public class MainActivity extends Activity {
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		EditText editText = new EditText(this);
		editText.setHint("Isso Ž um hint");
//		setContentView(R.layout.activity_main);
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
