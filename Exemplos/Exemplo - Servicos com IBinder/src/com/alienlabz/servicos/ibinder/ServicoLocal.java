package com.alienlabz.servicos.ibinder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Este serviço apenas aceita Binds.
 * 
 * @author Marlon Silva Carvalho
 * @since 1.0.0
 */
public class ServicoLocal extends Service {
	private IBinder binder = new LocalBinder();

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	public class LocalBinder extends Binder {

		public ServicoLocal getServico() {
			return ServicoLocal.this;
		}

	}

	public String meDeAParada() {
		return "Drogas!";
	}

}
