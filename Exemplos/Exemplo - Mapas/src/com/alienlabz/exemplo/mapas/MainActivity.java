package com.alienlabz.exemplo.mapas;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
1. Criar um novo projeto

2. Gerar o fingerprint do certificado de debug.
	2.1. keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
	2.2. keytool -list -v -keystore "C:\Users\your_user_name\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
	
3. Ir no Console - https://code.google.com/apis/console/?pli=1
	3.1. Criar um novo projeto
	3.2. Selecionar Services
	3.3. Marcar Google Maps Android API v2
	3.4. Clicar em API Access
	3.5. Clicar em Create New Android Key...
	3.6. Adicionar o Fingerprint e o package do aplicativo

4. Adicionar no Projeto a API Key gerada.
	4.1. Criar um metadata no AndroidManifest
	<meta-data
    	android:name="com.google.android.maps.v2.API_KEY"
	    android:value="your_api_key"/>

5. Adicionar as permiss›es para o seu aplicativo
		<permission
        	  android:name="com.example.mapdemo.permission.MAPS_RECEIVE"
          	  android:protectionLevel="signature"/>
        <uses-permission android:name="com.example.mapdemo.permission.MAPS_RECEIVE"/>
	
6. Adicionar outras permiss›es
	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	<uses-permission android:name="com.google.android.providers.gsf.permission.READ_GSERVICES"/>
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
	
7. Pedir a feature de opengl
	<uses-feature
	  android:glEsVersion="0x00020000"
	  android:required="true"/>
	  
8. Adicionar um fragment
	<?xml version="1.0" encoding="utf-8"?>
	<fragment xmlns:android="http://schemas.android.com/apk/res/android"
	  android:id="@+id/map"
	  android:layout_width="match_parent"
	  android:layout_height="match_parent"
	  class="com.google.android.gms.maps.MapFragment"/>
	  
9. Referenciar o Projeto Google Play Services que est‡ na SDK
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

}
