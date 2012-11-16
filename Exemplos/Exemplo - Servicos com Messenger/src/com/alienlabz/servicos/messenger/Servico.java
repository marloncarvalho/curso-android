package com.alienlabz.servicos.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.widget.Toast;

public class Servico extends Service {
	public static final int FACA_ALGO = 0;
	private final Messenger messenger = new Messenger(new IncomingHandler());
	private Messenger clientMessenger;
	
	@Override
	public IBinder onBind(Intent intent) {
		return messenger.getBinder();
	}

	class IncomingHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case FACA_ALGO:
				Toast.makeText(getApplicationContext(), "Servidor: Mensagem Recebida", Toast.LENGTH_SHORT).show();
				clientMessenger = msg.replyTo;
				Message message = Message.obtain(null, 0);
				try {
					clientMessenger.send(message);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
			default:
				super.handleMessage(msg);
			}
		}

	}

}
