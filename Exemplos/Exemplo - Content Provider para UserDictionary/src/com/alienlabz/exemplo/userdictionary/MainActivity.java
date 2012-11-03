package com.alienlabz.exemplo.userdictionary;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private EditText palavra;
	private Button inserir;
	private Button remover;
	private Button atualizar;
	private ListView listView;

	private Long selectedItemId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		palavra = (EditText) findViewById(R.id.palavra);
		inserir = (Button) findViewById(R.id.inserir);
		atualizar = (Button) findViewById(R.id.atualizar);
		remover = (Button) findViewById(R.id.remover);
		listView = (ListView) findViewById(R.id.listView);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
				if (pos > -1) {
					palavra.setText(((Cursor) listView.getAdapter().getItem(pos)).getString(0));
					selectedItemId = id;
				} else {
					selectedItemId = null;
				}
			}

		});

		inserir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				inserir();
				listar();
			}

		});

		atualizar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				atualizar();
				listar();
			}

		});

		remover.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				remover();
				listar();
			}

		});

		listar();
	}

	private void remover() {
		if (selectedItemId != null) {
			String selection = UserDictionary.Words._ID + "=?";
			String[] selectionArgs = new String[] { selectedItemId.toString() };

			getContentResolver().delete(UserDictionary.Words.CONTENT_URI, selection, selectionArgs);
			selectedItemId = null;
		}
	}

	private void atualizar() {
		if (selectedItemId != null) {
			ContentValues values = new ContentValues();
			values.put(UserDictionary.Words.APP_ID, "com.alienlabz.exemplo.contentprovider");
			values.put(UserDictionary.Words.LOCALE, "pt_BR");
			values.put(UserDictionary.Words.WORD, palavra.getText().toString());

			String selection = UserDictionary.Words._ID + "=?";
			String[] selectionArgs = new String[] { selectedItemId.toString() };

			getContentResolver().update(UserDictionary.Words.CONTENT_URI, values, selection, selectionArgs);
			selectedItemId = null;
		}
	}

	private void inserir() {
		ContentValues values = new ContentValues();
		values.put(UserDictionary.Words.APP_ID, "com.alienlabz.exemplo.contentprovider");
		values.put(UserDictionary.Words.LOCALE, "pt_BR");
		values.put(UserDictionary.Words.WORD, palavra.getText().toString());
		getContentResolver().insert(UserDictionary.Words.CONTENT_URI, values);
		selectedItemId = null;
	}

	private void listar() {
		String[] mProjection = new String[] { UserDictionary.Words.WORD, UserDictionary.Words._ID };
		String mSelectionClause = null;
		String[] mSelectionArgs = null;
		String mSortOrder = null;

		Cursor cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI, mProjection, mSelectionClause,
				mSelectionArgs, mSortOrder);

		String[] from = new String[] { UserDictionary.Words.WORD };
		int[] to = new int[] { android.R.id.text1 };

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from,
				to, 0);
		listView.setAdapter(adapter);
	}
}
