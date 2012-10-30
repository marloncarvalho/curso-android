package com.alienlabz.exemplo.fragments;

import com.alienlabz.exemplo.fragments.ListaFragment.OnItemListSelectedListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnItemListSelectedListener {
	private Button button;
	private Fragment nextFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_container, new ListaFragment());
		nextFragment = new MenuFragment();
		transaction.commit();

		button = (Button) findViewById(R.id.button_proximo);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentTransaction transaction = manager.beginTransaction();
				transaction.replace(R.id.fragment_container, nextFragment);
				transaction.addToBackStack(null);
				transaction.commit();
				if (nextFragment instanceof MenuFragment) {
					nextFragment = new ListaFragment();
				} else {
					nextFragment = new MenuFragment();
				}
			}
		});
	}

	@Override
	public void onItemSelected() {
		Toast.makeText(this, "Selecionado Item", Toast.LENGTH_LONG).show();
	}

}
