package net.silvacarvalho.marlon.ciclodevida;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Exemplo que apresenta um Log para cada fase do ciclo de vida de uma aplicação
 * Android.
 * 
 * @author Marlon Silva Carvalho
 */
public class CicloDeVidaApplication extends Application {

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.d("CicloDeVida", "onConfigurationChanged");
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("CicloDeVida", "onCreate");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		Log.d("CicloDeVida", "onLowMemory");
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.d("CicloDeVida", "onTerminate");
	}

	@Override
	public void onTrimMemory(int level) {
		Log.d("CicloDeVida", "onTrimMemory");
	}

}
