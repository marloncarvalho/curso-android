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
	// Estender esta classe é opcional.
	// Uma vez criada, lembre de declarar ela no AndroidManifest.xml

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// Aconteceu alguma mudança na configuração do dispositivo!
		// Pode ter ocorrido uma mudança de orientação, Locale e qualquer outra configuração.
		
		super.onConfigurationChanged(newConfig);
		Log.d("CicloDeVida", "onConfigurationChanged");
	}

	@Override
	public void onCreate() {
		// Sempre chamado quando a aplicação é criada.
		
		super.onCreate();
		Log.d("CicloDeVida", "onCreate");
	}

	@Override
	public void onLowMemory() {
		// O sistema (Android) em geral está sem memória e está pedindo para os aplicativos liberarem memória.
		// Aqui você libera recursos (memória) e o Android, logo após chamar este método, faz um Garbage Collection.
		
		super.onLowMemory();
		Log.d("CicloDeVida", "onLowMemory");
	}

	@Override
	public void onTerminate() {
		// É apenas para ambientes emulados.
		
		super.onTerminate();
		Log.d("CicloDeVida", "onTerminate");
	}

	@Override
	public void onTrimMemory(int level) {
		// É chamado quando o Android acredita que é uma boa hora para o aplicativo liberar recursos.
		// Por exemplo, quando seu aplicativo vai para background e talvez não tenha memória suficiente para manter ele
		// neste estado.

		// Você pode checar o LEVEL para ver em que nível está o uso da memória.
		
		Log.d("CicloDeVida", "onTrimMemory");
	}

}
