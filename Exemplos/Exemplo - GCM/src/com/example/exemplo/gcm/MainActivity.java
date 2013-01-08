package com.example.exemplo.gcm;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gcm.GCMRegistrar;

/**
Passos necessários:

0. Adicionar nos Extras

1. Ir no Console https://code.google.com/apis/console/

2. Criar um Projeto e anotar o projectId.
	2.1. Ir em Services
	2.2. Habilitar Google Cloud Messaging for Android
	2.3. Ir em API Access
	2.4. Clicar em Create New Server API - É melhor para colocar uma whitelist de IPs de servidores que podem acessar.
	2.5. Anotar a Chave criada.

3. Copiar as bibliotecas da SDK

4. Alterar o AndroidManifest.xml

	4.1. Adicionar permissão própria. Não é necessário para Android 4.1
		<permission android:name="my_app_package.permission.C2D_MESSAGE" android:protectionLevel="signature" />
		<uses-permission android:name="my_app_package.permission.C2D_MESSAGE" /> 

	4.2. Pedir outras permissões
		<uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
		<uses-permission android:name="android.permission.INTERNET" /> 
		<uses-permission android:name="android.permission.GET_ACCOUNTS" />
		<uses-permission android:name="android.permission.WAKE_LOCK" />
	
	4.3. Adicionar o BroadcastReceiver
	<receiver android:name="com.google.android.gcm.GCMBroadcastReceiver" android:permission="com.google.android.c2dm.permission.SEND" >
		  <intent-filter>
		    <action android:name="com.google.android.c2dm.intent.RECEIVE" />
		    <action android:name="com.google.android.c2dm.intent.REGISTRATION" />
		    <category android:name="my_app_package" />
		  </intent-filter>
	</receiver>
	
	4.4. Adicionar o seu próprio Serviço
	<service android:name=".GCMIntentService" />
	
5. Criar o Serviço que estende de GCMBaseIntentService
	5.1. Sobrescrever os métodos
	
6. Criar a MainActivity

 * @author Marlon Silva Carvalho
 * @since 1.0.0
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		configureGCM();
	}

	/**
	 * Configuring Google Cloud Messaging.
	 */
	private void configureGCM() {
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);

		final String regId = GCMRegistrar.getRegistrationId(this);

		if (regId == null || "".equals(regId)) {
			GCMRegistrar.register(this, GCMIntentService.SENDER_ID);
		} else {
			if (!GCMRegistrar.isRegisteredOnServer(this)) {
				new AsyncTask<Void, String, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						Webservice.register(MainActivity.this, "marloncarvalho", regId);
						return null;
					}

				}.execute();

			} else {
				GCMRegistrar.unregister(this);
			}
		}
	}
}
