package com.alienlabz.servico.remoto.com.messenger;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;
	private boolean bound = false;
	private Messenger serviceMessenger;
	private Messenger clientMessenger = new Messenger(new ClientIncomingHandler());

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (bound) {
					Message message = Message.obtain(null, 0, 0, 0);
					message.replyTo = clientMessenger;
					try {
						serviceMessenger.send(message);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}

		});

	}

	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = new Intent();
		intent.setAction("com.alienlabz.servico");
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (bound) {
			unbindService(connection);
			bound = false;
		}
	}

	class ClientIncomingHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			Toast.makeText(MainActivity.this, "Activity: Mensagem Recebida Também!", Toast.LENGTH_SHORT).show();
		}

	};

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			serviceMessenger = null;
			bound = false;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			bound = true;
			serviceMessenger = new Messenger(service);
		}

	};
}
