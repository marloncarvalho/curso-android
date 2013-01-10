package net.silvacarvalho.marlon.consultar.contatos;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView1);

		final Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
				null, null, null);

		final String[] from = new String[] { ContactsContract.CommonDataKinds.Phone.NUMBER };
		final int[] to = new int[] { android.R.id.text1 };

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from,
				to, 0);
		listView.setAdapter(adapter);

	}

}
